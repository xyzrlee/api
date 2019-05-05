package app.illl.api.struct.io;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@ToString
public class Response<T> implements ApiResponse {

    @Getter
    @Setter
    private boolean ok;
    @Getter
    @Setter
    private ZonedDateTime timestamp;
    @Getter
    @Setter
    private T data;

}
