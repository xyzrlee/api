package app.rk3.api.struct.io.url;

import java.time.ZonedDateTime;

public class URLExpandResponse {
    private String url;
    private ZonedDateTime time;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "URLExpandResponse{" +
                "url='" + url + '\'' +
                ", time=" + time +
                '}';
    }
}
