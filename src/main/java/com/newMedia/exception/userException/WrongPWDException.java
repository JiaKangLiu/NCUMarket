package com.newMedia.exception.userException;

public class WrongPWDException extends UserException {
    public WrongPWDException(String message) {
        super(message);
    }

    public WrongPWDException(String message, Throwable cause) {
        super(message, cause);
    }
}
