package app.rk3.api.struct.io;

import java.time.ZonedDateTime;

public abstract class AbstractApiResponse {

    private ZonedDateTime _time;

    public ZonedDateTime get_time() {
        return _time;
    }

    public void set_time(ZonedDateTime _time) {
        this._time = _time;
    }

}
