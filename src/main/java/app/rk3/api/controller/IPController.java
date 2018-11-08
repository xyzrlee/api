package app.rk3.api.controller;

import app.rk3.api.struct.io.ip.IPResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
public class IPController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "/ip", method = RequestMethod.GET)
    public IPResponse getRequestIp(HttpServletRequest httpServletRequest) {
        String ip = httpServletRequest.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getRemoteAddr();
        }
        IPResponse ipResponse = new IPResponse();
        ipResponse.setIp(ip);
        ipResponse.setTime(ZonedDateTime.now(ZoneId.of("UTC")));
        return ipResponse;
    }

}
