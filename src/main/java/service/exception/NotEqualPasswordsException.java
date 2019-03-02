package service.exception;

public class NotEqualPasswordsException extends Exception {

    private static final long serialVersionUID = 8924485845383146075L;

    public NotEqualPasswordsException() {
        super();
    }

    public NotEqualPasswordsException(String message) {
        super(message);
    }

    public NotEqualPasswordsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEqualPasswordsException(Throwable cause) {
        super(cause);
    }

    protected NotEqualPasswordsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
