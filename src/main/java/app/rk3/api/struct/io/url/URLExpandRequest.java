package app.rk3.api.struct.io.url;

public class URLExpandRequest {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "URLExpandRequest{" +
                "url='" + url + '\'' +
                '}';
    }
}
