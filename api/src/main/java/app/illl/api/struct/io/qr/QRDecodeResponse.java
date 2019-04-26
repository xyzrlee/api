package app.illl.api.struct.io.qr;

import app.illl.api.struct.io.ApiResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class QRDecodeResponse implements ApiResponse {

    @Getter
    @Setter
    private String text;

}
