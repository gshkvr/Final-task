package service.exception;

public class LoginExistsException extends Exception {

    private static final long serialVersionUID = 7225229618218223098L;

    public LoginExistsException() {
        super();
    }

    public LoginExistsException(String message) {
        super(message);
    }

    public LoginExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginExistsException(Throwable cause) {
        super(cause);
    }

    protected LoginExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
