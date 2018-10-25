package app.rk3.api.controller;

import app.rk3.api.exception.BadRequestException;
import app.rk3.api.exception.InternalServerErrorException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class URLController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(path = "/url/expand")
    public Map expand(HttpServletRequest request) {
        String shortenedUrl = request.getParameter("url");
        if (StringUtils.isBlank(shortenedUrl))
            throw new BadRequestException("[url] is expected.");
        Map<String, Object> resultMap = new HashMap<>();
        if (!shortenedUrl.matches("^http[s]?://.*"))
            shortenedUrl = "http://" + shortenedUrl;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpClientContext httpClientContext = HttpClientContext.create();
        HttpGet httpGet = new HttpGet();
        httpGet.setURI(URI.create(shortenedUrl));
        String url = "";
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet, httpClientContext);
            List<URI> redirectList = httpClientContext.getRedirectLocations();
            if (redirectList.size() > 0)
                url = redirectList.get(redirectList.size() - 1).toString();
            else
                url = shortenedUrl;
        } catch (IOException e) {
            throw new InternalServerErrorException();
        }
        resultMap.put("url", url);
        return resultMap;
    }

}
