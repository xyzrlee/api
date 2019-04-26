package app.illl.api.struct.io.ip;

import app.illl.api.struct.io.ApiResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class IPResponse implements ApiResponse {

    @Getter
    @Setter
    private String ip;

}
