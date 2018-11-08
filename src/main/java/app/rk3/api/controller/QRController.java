package app.rk3.api.controller;

import app.rk3.api.struct.io.qr.QRDecodeRequest;
import app.rk3.api.struct.io.qr.QRDecodeResponse;
import app.rk3.api.util.FileUtils;
import app.rk3.api.util.QRCodeUtils;
import com.google.zxing.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
public class QRController {

    private static final String TEMP_FILE_PREFIX = "api-qr-";
    private static final String TEMP_FILE_SUFFIX = "";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/qr/decode")
    private QRDecodeResponse decode(QRDecodeRequest qrDecodeRequest, HttpServletRequest request) {
        MultipartFile multipartFile = qrDecodeRequest.getFile();
        if (null == multipartFile) return null;
        File file = FileUtils.createTempFile(multipartFile, TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);
        Result result = QRCodeUtils.decode(file);
        file.delete();
        QRDecodeResponse qrDecodeResponse = new QRDecodeResponse();
        qrDecodeResponse.setText(result.getText());
        qrDecodeResponse.setTime(ZonedDateTime.now(ZoneId.of("UTC")));
        return qrDecodeResponse;
    }

}
