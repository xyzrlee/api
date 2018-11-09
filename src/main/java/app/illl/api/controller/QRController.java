package app.illl.api.controller;

import app.illl.api.struct.io.qr.QRDecodeRequest;
import app.illl.api.struct.io.qr.QRDecodeResponse;
import app.illl.api.util.FileUtils;
import app.illl.api.util.QRCodeUtils;
import com.google.zxing.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

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
        return qrDecodeResponse;
    }

}
