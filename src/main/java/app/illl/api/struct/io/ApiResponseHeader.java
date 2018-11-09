package app.illl.api.struct.io;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.ZonedDateTime;

public class ApiResponseHeader {

    private ZonedDateTime time;

    public final ZonedDateTime getTime() {
        return time;
    }

    public final void setTime(ZonedDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }

}
