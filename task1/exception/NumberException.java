package com.company.task1.exception;

public class NumberException extends Exception {
    public NumberException() {
    }

    public NumberException(String message) {
        super(message);
    }

    public NumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
