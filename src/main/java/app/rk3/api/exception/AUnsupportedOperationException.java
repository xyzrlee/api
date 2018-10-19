package app.rk3.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AUnsupportedOperationException extends UnsupportedOperationException {
    public AUnsupportedOperationException() {
        super();
    }

    public AUnsupportedOperationException(String message) {
        super(message);
    }
}
