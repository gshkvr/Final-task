package service.exception;

public class EmptyTypeException extends Exception {

    private static final long serialVersionUID = 1408942568274650989L;

    public EmptyTypeException() {
        super();
    }

    public EmptyTypeException(String message) {
        super(message);
    }

    public EmptyTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyTypeException(Throwable cause) {
        super(cause);
    }

    protected EmptyTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
