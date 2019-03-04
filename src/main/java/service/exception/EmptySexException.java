package service.exception;

public class EmptySexException extends Exception {

    private static final long serialVersionUID = -6674431066940053881L;

    public EmptySexException() {
        super();
    }

    public EmptySexException(String message) {
        super(message);
    }

    public EmptySexException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptySexException(Throwable cause) {
        super(cause);
    }

    protected EmptySexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
