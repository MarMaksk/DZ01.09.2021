package task1.exception;

public class ContactNotFoundException extends Exception{
    public ContactNotFoundException() {
        super("Contact not found");
    }

    public ContactNotFoundException(String message) {
        super(message);
    }

    public ContactNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
