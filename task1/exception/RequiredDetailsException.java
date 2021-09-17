package task1.exception;

public class RequiredDetailsException extends Exception {
    public RequiredDetailsException() {
        super("Требуется указать имя и книгу контактов");
    }

    public RequiredDetailsException(String message) {
        super(message);
    }
}
