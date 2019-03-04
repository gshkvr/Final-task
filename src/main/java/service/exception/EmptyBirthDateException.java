package service.exception;

public class EmptyBirthDateException extends Exception {

    private static final long serialVersionUID = 7417090518352674773L;

    public EmptyBirthDateException() {
        super();
    }

    public EmptyBirthDateException(String message) {
        super(message);
    }

    public EmptyBirthDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyBirthDateException(Throwable cause) {
        super(cause);
    }

    protected EmptyBirthDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
