package app.illl.api.controller;

import app.illl.api.exception.BadRequestException;
import app.illl.api.exception.InternalServerErrorException;
import app.illl.api.struct.io.ApiRequest;
import app.illl.api.struct.io.ApiResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
public class URL {

    @GetMapping(path = "/url/expand")
    public URLExpandResponse urlExpand(URLExpandRequest urlExpandRequest) {
        String shortenedUrl = urlExpandRequest.getUrl();
        if (StringUtils.isBlank(shortenedUrl)) {
            throw new BadRequestException("[url] is expected.");
        }
        if (!shortenedUrl.matches("^http[s]?://.*")) {
            shortenedUrl = "http://" + shortenedUrl;
        }
        String url = shortenedUrl;
        int redirects = 0;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpClientContext httpClientContext = HttpClientContext.create();
            HttpGet httpGet = new HttpGet();
            httpGet.setURI(URI.create(shortenedUrl));
            httpClient.execute(httpGet, httpClientContext);
            List<URI> redirectList = httpClientContext.getRedirectLocations();
            if (!redirectList.isEmpty()) {
                redirects = redirectList.size();
                url = redirectList.get(redirects - 1).toString();
            }
        } catch (IOException e) {
            throw new InternalServerErrorException(e);
        }
        URLExpandResponse urlExpandResponse = new URLExpandResponse();
        urlExpandResponse.setUrl(url);
        urlExpandResponse.setRedirects(redirects);
        return urlExpandResponse;
    }

    @ToString
    private static class URLExpandRequest implements ApiRequest {
        @Getter
        @Setter
        private String url;
    }

    @ToString
    private static class URLExpandResponse implements ApiResponse {
        @Getter
        @Setter
        private String url;
        @Getter
        @Setter
        private int redirects;
    }


}
