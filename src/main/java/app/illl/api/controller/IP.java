package app.illl.api.controller;

import app.illl.api.struct.io.ip.IPResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IP {

    private static final String IP_UNKNOWN = "unknown";

    @GetMapping(path = "/ip")
    public IPResponse getRequestIp(HttpServletRequest httpServletRequest) {
        String ip = httpServletRequest.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getRemoteAddr();
        }
        IPResponse ipResponse = new IPResponse();
        ipResponse.setIp(ip);
        return ipResponse;
    }

}
