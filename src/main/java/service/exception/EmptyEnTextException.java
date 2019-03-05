package service.exception;

public class EmptyEnTextException extends Exception {

    private static final long serialVersionUID = -837667400292070421L;

    public EmptyEnTextException() {
        super();
    }

    public EmptyEnTextException(String message) {
        super(message);
    }

    public EmptyEnTextException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyEnTextException(Throwable cause) {
        super(cause);
    }

    protected EmptyEnTextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
