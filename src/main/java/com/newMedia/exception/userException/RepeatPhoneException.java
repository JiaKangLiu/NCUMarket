package com.newMedia.exception.userException;

public class RepeatPhoneException extends UserException {

    public RepeatPhoneException(String message) {
        super(message);
    }

    public RepeatPhoneException(String message, Throwable cause) {
        super(message, cause);
    }
}
