package app.illl.api.controller;

import app.illl.api.exception.BadRequestException;
import app.illl.api.exception.InternalServerErrorException;
import app.illl.api.struct.io.ApiRequest;
import app.illl.api.struct.io.ApiResponse;
import app.illl.api.struct.io.url.URLExpandRequest;
import app.illl.api.struct.io.url.URLExpandResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
public class URLController {

    @PostMapping(path = "/url/expand")
    public ApiResponse<URLExpandResponse> expand(ApiRequest<URLExpandRequest> apiRequest) {
        String shortenedUrl = apiRequest.getBody().getUrl();
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
            if (redirectList.isEmpty())
                url = shortenedUrl;
            else
                url = redirectList.get(redirectList.size() - 1).toString();
        } catch (IOException e) {
            throw new InternalServerErrorException();
        }
        URLExpandResponse urlExpandResponse = new URLExpandResponse();
        urlExpandResponse.setUrl(url);
        return new ApiResponse<>(urlExpandResponse);
    }

}
