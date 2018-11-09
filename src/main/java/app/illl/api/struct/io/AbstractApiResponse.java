package app.illl.api.struct.io;

import java.time.ZonedDateTime;

public abstract class AbstractApiResponse {

    private ZonedDateTime _time;

    public final ZonedDateTime get_time() {
        return _time;
    }

    public final void set_time(ZonedDateTime _time) {
        this._time = _time;
    }

}
