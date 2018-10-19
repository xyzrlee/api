package app.rk3.api.exception;

public class UnsupportedOperationException extends BadRequestException {
    public UnsupportedOperationException() {
        super();
    }

    public UnsupportedOperationException(String message) {
        super(message);
    }
}
