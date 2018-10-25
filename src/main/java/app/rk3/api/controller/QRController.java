package app.rk3.api.controller;

import app.rk3.api.exception.UnsupportedOperationException;
import app.rk3.api.util.FileUtils;
import app.rk3.api.util.QRCodeUtils;
import com.google.zxing.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
public class QRController {

    private static final String TEMP_FILE_PREFIX = "api-qr-";
    private static final String TEMP_FILE_SUFFIX = "";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/qr/decode")
    private Map decode(HttpServletRequest request) {
        if (!(request instanceof MultipartRequest))
            throw new UnsupportedOperationException();
        MultipartFile multipartFile = ((MultipartRequest) request).getFile("file");
        if (null == multipartFile) return null;
        File file = FileUtils.createTempFile(multipartFile, TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);
        Result result = QRCodeUtils.decode(file);
        file.delete();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("text", result.getText());
        return responseMap;
    }

}
