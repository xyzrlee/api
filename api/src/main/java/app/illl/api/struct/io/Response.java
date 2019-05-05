package app.illl.api.struct.io;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@ToString
@JsonPropertyOrder({"timestamp", "status", "data"})
public class Response<T> implements ApiResponse {

    @Getter
    @Setter
    private ZonedDateTime timestamp;
    @Getter
    @Setter
    private HttpStatus status;
    @Getter
    @Setter
    private T data;

    @JsonGetter("status")
    private int getStatusCode() {
        return this.status.value();
    }

}
