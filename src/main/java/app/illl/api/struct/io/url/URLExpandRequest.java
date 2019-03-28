package app.illl.api.struct.io.url;

import app.illl.api.struct.io.ApiRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class URLExpandRequest implements ApiRequest {

    @Getter
    @Setter
    private String url;

}
