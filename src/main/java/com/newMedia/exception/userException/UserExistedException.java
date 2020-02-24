package com.newMedia.exception.userException;

public class UserExistedException extends UserException {
    public UserExistedException(String message) {
        super(message);
    }

    public UserExistedException(String message, Throwable cause) {
        super(message, cause);
    }
}
