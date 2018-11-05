package app.rk3.api.controller;

import app.rk3.api.exception.BadRequestException;
import app.rk3.api.exception.InternalServerErrorException;
import app.rk3.api.struct.io.url.URLExpandRequest;
import app.rk3.api.struct.io.url.URLExpandResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;

@RestController
public class URLController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(path = "/url/expand")
    public URLExpandResponse expand(URLExpandRequest urlExpandRequest, HttpServletRequest request) {
        String shortenedUrl = urlExpandRequest.getUrl();
        if (StringUtils.isBlank(shortenedUrl))
            throw new BadRequestException("[url] is expected.");
        if (!shortenedUrl.matches("^http[s]?://.*"))
            shortenedUrl = "http://" + shortenedUrl;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpClientContext httpClientContext = HttpClientContext.create();
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(URI.create(shortenedUrl));
        String url = "";
        try {
            httpClient.execute(httpGet, httpClientContext);
            List<URI> redirectList = httpClientContext.getRedirectLocations();
            if (redirectList.size() > 0)
                url = redirectList.get(redirectList.size() - 1).toString();
            else
                url = shortenedUrl;
        } catch (IOException e) {
            throw new InternalServerErrorException();
        }
        URLExpandResponse urlExpandResponse = new URLExpandResponse();
        urlExpandResponse.setUrl(url);
        urlExpandResponse.setTime(ZonedDateTime.now());
        return urlExpandResponse;
    }

}
