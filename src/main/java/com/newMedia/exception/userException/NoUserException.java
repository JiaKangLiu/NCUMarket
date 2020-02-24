package com.newMedia.exception.userException;

public class NoUserException extends UserException {
    public NoUserException(String message) {
        super(message);
    }

    public NoUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
