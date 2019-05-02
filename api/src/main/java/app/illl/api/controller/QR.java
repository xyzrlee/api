package app.illl.api.controller;

import app.illl.api.struct.io.ApiRequest;
import app.illl.api.struct.io.ApiResponse;
import app.illl.api.util.FileUtils;
import app.illl.api.util.QRCodeUtils;
import com.google.zxing.Result;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@RestController
public class QR {

    private static final String TEMP_FILE_PREFIX = "api-qr-";
    private static final String TEMP_FILE_SUFFIX = "";

    @PostMapping("/qr/decode")
    public QRDecodeResponse decode(QRDecodeRequest qrDecodeRequest) {
        log.info("{}", qrDecodeRequest);
        MultipartFile multipartFile = qrDecodeRequest.getFile();
        if (null == multipartFile) return null;
        File file = FileUtils.createTempFile(multipartFile, TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);
        Result result = QRCodeUtils.decode(file);
        FileUtils.deleteWithoutException(file);
        QRDecodeResponse qrDecodeResponse = new QRDecodeResponse();
        qrDecodeResponse.setText(result.getText());
        return qrDecodeResponse;
    }

    @ToString
    private static class QRDecodeRequest implements ApiRequest {
        @Getter
        @Setter
        private MultipartFile file;
    }

    @ToString
    private static class QRDecodeResponse implements ApiResponse {
        @Getter
        @Setter
        private String text;
    }

}
