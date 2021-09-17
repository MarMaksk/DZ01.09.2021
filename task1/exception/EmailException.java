package task1.exception;

public class EmailException extends Exception {
    public EmailException() {
        super("Uncorrect email");
    }

    public EmailException(String message) {
        super(message);
    }

    public EmailException(String message, Throwable cause) {
        super(message, cause);
    }
}