package com.newMedia.exception.userException;

public class RepeatEmailException extends UserException {
    public RepeatEmailException(String message) {
        super(message);
    }

    public RepeatEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
