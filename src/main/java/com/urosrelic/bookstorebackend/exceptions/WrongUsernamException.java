package com.urosrelic.bookstorebackend.exceptions;

public class WrongUsernamException extends Exception {
    public WrongUsernamException() {
        super("Wrong username");
    }

    public WrongUsernamException(String message) {
        super(message);
    }

    public WrongUsernamException(String message, Throwable cause) {
        super(message, cause);
    }
}
