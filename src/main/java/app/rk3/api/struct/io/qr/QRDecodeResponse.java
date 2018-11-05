package app.rk3.api.struct.io.qr;

import java.time.ZonedDateTime;

public class QRDecodeResponse {
    private String text;
    private ZonedDateTime time;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "QRDecodeResponse{" +
                "text='" + text + '\'' +
                ", time=" + time +
                '}';
    }
}
