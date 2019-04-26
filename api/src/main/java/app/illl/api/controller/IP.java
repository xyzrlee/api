package app.illl.api.controller;

import app.illl.api.struct.io.ip.IPResponse;
import com.google.common.net.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class IP {

    private static final String IP_UNKNOWN = "unknown";

    @GetMapping(path = "/ip")
    public IPResponse getRequestIp(HttpServletRequest httpServletRequest) {
        String ip = httpServletRequest.getHeader(HttpHeaders.X_FORWARDED_FOR);
        log.info("{}: {}", HttpHeaders.X_FORWARDED_FOR, ip);
        if (isValidIP(ip)) {
            String[] ips = StringUtils.split(ip, ',');
            ip = ips[0];
        }
        if (!isValidIP(ip)) {
            ip = httpServletRequest.getRemoteAddr();
        }
        IPResponse ipResponse = new IPResponse();
        ipResponse.setIp(ip);
        return ipResponse;
    }

    private boolean isValidIP(String ip) {
        return ip != null && !StringUtils.isBlank(ip) && !StringUtils.equals(IP_UNKNOWN, ip);
    }

}