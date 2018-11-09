package app.illl.api.struct.io;

public class ApiResponse<T> {

    private ApiResponseHeader header;
    private T body;

    public ApiResponse(ApiResponseHeader header, T body) {
        this.setHeader(header);
        this.setBody(body);
    }

    public ApiResponse(T body) {
        this(null, body);
    }

    public ApiResponseHeader getHeader() {
        return header;
    }

    public void setHeader(ApiResponseHeader header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
