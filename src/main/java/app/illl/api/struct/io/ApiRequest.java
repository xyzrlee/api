package app.illl.api.struct.io;

public class ApiRequest<T> {

    private ApiRequestHeader header;
    private T body;

    public ApiRequest(ApiRequestHeader header, T body) {
        this.setHeader(header);
        this.setBody(body);
    }

    public ApiRequest(T body) {
        this(null, body);
    }

    public ApiRequestHeader getHeader() {
        return header;
    }

    public void setHeader(ApiRequestHeader header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
