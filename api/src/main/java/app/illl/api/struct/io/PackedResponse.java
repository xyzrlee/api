package app.illl.api.struct.io;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@ToString
@JsonPropertyOrder({
        "timestamp",
        "status",
        "data"
})
public class PackedResponse<T> {

    private static final int STATUS_UNKNOWN = 999;

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
        if (null == this.status) {
            return STATUS_UNKNOWN;
        }
        return this.status.value();
    }

    public void setStatusByCode(int statusCode) {
        this.status = HttpStatus.resolve(statusCode);
    }

}
