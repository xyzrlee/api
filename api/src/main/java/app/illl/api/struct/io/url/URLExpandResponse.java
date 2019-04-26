package app.illl.api.struct.io.url;

import app.illl.api.struct.io.ApiResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class URLExpandResponse implements ApiResponse {

    @Getter
    @Setter
    private String url;

}
