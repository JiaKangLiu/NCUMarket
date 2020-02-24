package com.newMedia.exception.userException;

public class WrongUserException extends UserException {
    public WrongUserException(String message) {
        super(message);
    }

    public WrongUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
