package app.illl.api.controller;

import app.illl.api.struct.io.ip.IPResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(value = "IP", description = "获得公网IP")
@RestController
public class IPController {

    private static final String IP_UNKNOWN = "unknown";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "获取请求IP")
    @GetMapping(path = "/ip")
    public IPResponse getRequestIp(HttpServletRequest httpServletRequest) {
        logger.info("{}", getClass().getPackage().getImplementationVersion());
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
