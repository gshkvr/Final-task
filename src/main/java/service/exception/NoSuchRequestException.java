package service.exception;

public class NoSuchRequestException extends Exception {

    private static final long serialVersionUID = 4933381768390115761L;

    public NoSuchRequestException() {
        super();
    }

    public NoSuchRequestException(String message) {
        super(message);
    }

    public NoSuchRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchRequestException(Throwable cause) {
        super(cause);
    }

    protected NoSuchRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
