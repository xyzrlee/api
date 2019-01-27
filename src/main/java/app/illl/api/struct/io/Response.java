package app.illl.api.struct.io;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.ZonedDateTime;

public class Response<T> implements ApiResponse {

    private boolean ok;
    private ZonedDateTime time;
    private T data;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public final ZonedDateTime getTime() {
        return time;
    }

    public final void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }

}
