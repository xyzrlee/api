package app.illl.api.struct.io.qr;

import app.illl.api.struct.io.ApiRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@ToString
public class QRDecodeRequest implements ApiRequest {

    @Getter
    @Setter
    private MultipartFile file;

}
