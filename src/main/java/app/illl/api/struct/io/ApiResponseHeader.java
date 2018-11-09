package app.illl.api.struct.io;

import java.time.ZonedDateTime;

public class ApiResponseHeader {

    private ZonedDateTime time;

    public final ZonedDateTime getTime() {
        return time;
    }

    public final void setTime(ZonedDateTime time) {
        this.time = time;
    }

}
