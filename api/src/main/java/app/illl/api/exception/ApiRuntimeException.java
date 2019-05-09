package app.illl.api.exception;

@SuppressWarnings("WeakerAccess")
public abstract class ApiRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 8991985040909609093L;

    public ApiRuntimeException() {
    }

    public ApiRuntimeException(String message) {
        super(message);
    }

    public ApiRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiRuntimeException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    protected ApiRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
