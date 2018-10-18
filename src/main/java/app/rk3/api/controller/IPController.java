package app.rk3.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IPController {

    @RequestMapping(value = "/ip", method = RequestMethod.GET)
    public Map getRequestIp(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("ip", ip);
        return responseMap;
    }

}
