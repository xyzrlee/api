package app.illl.api.controller;

import app.illl.api.struct.io.ip.IPResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IPController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "/ip", method = RequestMethod.GET)
    public IPResponse getRequestIp(HttpServletRequest httpServletRequest) {
        logger.info("getRequestIp");
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
        return ipResponse;
    }

}
