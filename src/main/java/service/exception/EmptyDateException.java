package service.exception;

public class EmptyDateException extends Exception {

    private static final long serialVersionUID = 6530785043199283410L;

    public EmptyDateException() {
        super();
    }

    public EmptyDateException(String message) {
        super(message);
    }

    public EmptyDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyDateException(Throwable cause) {
        super(cause);
    }

    protected EmptyDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
