/*
 * MIT License
 *
 * Copyright (c) 2020 Ricky Li
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package app.illl.api.controller;

import app.illl.api.exception.BadRequestException;
import app.illl.api.exception.InternalServerErrorException;
import app.illl.api.struct.io.ApiRequest;
import app.illl.api.struct.io.ApiResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@Slf4j
public class URLExpand {

    private final RequestConfig defaultRequestConfig = RequestConfig.custom()
            .setSocketTimeout(5000)
            .setConnectTimeout(5000)
            .setConnectionRequestTimeout(5000)
            .build();

    @GetMapping(path = "/url/expand")
    @Cacheable(
            value = "urlExpand",
            key = "#urlExpandRequest.getUrl()",
            condition = "#urlExpandRequest.getUrl() != null"
    )
    public URLExpandResponse urlExpand(URLExpandRequest urlExpandRequest) {
        String shortenedUrl = urlExpandRequest.getUrl();
        if (StringUtils.isBlank(shortenedUrl)) {
            throw new BadRequestException("[url] is expected.");
        }
        if (!UrlUtils.isAbsoluteUrl(shortenedUrl)) {
            shortenedUrl = "http://" + shortenedUrl;
        }
        URI uri = URI.create(shortenedUrl);
        String url;
        try {
            url = uri.toURL().toString();
        } catch (MalformedURLException e) {
            throw new BadRequestException(e.getMessage());
        }
        int redirects = 0;
        HttpClientContext httpClientContext = HttpClientContext.create();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .disableAutomaticRetries()
                .setDefaultRequestConfig(defaultRequestConfig)
                .build()
        ) {
            HttpGet httpGet = new HttpGet();
            httpGet.setURI(URI.create(shortenedUrl));
            httpClient.execute(httpGet, httpClientContext);
        } catch (UnknownHostException e) {
            throw new BadRequestException("Unknown host: " + uri.getHost(), e);
        } catch (ConnectTimeoutException | HttpHostConnectException | NoHttpResponseException e) {
            throw new InternalServerErrorException(e);
        } catch (IOException e) {
            log.error("", e);
            throw new InternalServerErrorException("Unexpected error", e);
        }
        List<URI> redirectList = httpClientContext.getRedirectLocations();
        if (null != redirectList && !redirectList.isEmpty()) {
            redirects = redirectList.size();
            url = redirectList.get(redirects - 1).toString();
        }
        URLExpandResponse urlExpandResponse = new URLExpandResponse();
        urlExpandResponse.setUrl(url);
        urlExpandResponse.setRedirects(redirects);
        return urlExpandResponse;
    }

    private static class URLExpandRequest implements ApiRequest, Serializable {
        private static final long serialVersionUID = 1374156479699606525L;
        @Getter
        @Setter
        private String url;
    }

    private static class URLExpandResponse implements ApiResponse, Serializable {
        private static final long serialVersionUID = -9116713401881515869L;
        @Getter
        @Setter
        private String url;
        @Getter
        @Setter
        private int redirects;
    }


}
