package service.exception;

public class EmptyNationalityException extends Exception {

    private static final long serialVersionUID = -7310122496807975135L;

    public EmptyNationalityException() {
        super();
    }

    public EmptyNationalityException(String message) {
        super(message);
    }

    public EmptyNationalityException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyNationalityException(Throwable cause) {
        super(cause);
    }

    protected EmptyNationalityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
