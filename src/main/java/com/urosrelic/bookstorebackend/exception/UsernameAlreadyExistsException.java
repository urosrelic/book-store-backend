package com.urosrelic.bookstorebackend.exception;

public class UsernameAlreadyExistsException extends Exception {

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
