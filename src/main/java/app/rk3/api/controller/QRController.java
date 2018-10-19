package app.rk3.api.controller;

import app.rk3.api.exception.AUnsupportedOperationException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class QRController {

    private static final String METHOD_DECODE = "d";
    private static final String METHOD_ENCODE = "e";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/qr")
    public Map root(HttpServletRequest request) {
        String m = request.getParameter("m");
        if (null == m)
            throw new AUnsupportedOperationException("parameter m is missing");
        if (StringUtils.equals(m, METHOD_DECODE))
            return this.decode(request);
        throw new AUnsupportedOperationException(String.format("unsupported operation: m=%s", m));
    }

    private Map decode(HttpServletRequest request) {
        logger.info("request instanceof MultipartRequest: {}", request instanceof MultipartRequest);
        if (!(request instanceof MultipartRequest))
            throw new AUnsupportedOperationException();
        MultipartFile file = ((MultipartRequest) request).getFile("file");
        Map<String, Object> responseMap = new HashMap<>();
        return responseMap;
    }

}
