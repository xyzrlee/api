package app.rk3.api.struct.io.ip;

import java.time.ZonedDateTime;

public class IPResponse {

    private String ip;
    private ZonedDateTime time;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "IPResponse{" +
                "ip='" + ip + '\'' +
                ", time=" + time +
                '}';
    }
}
