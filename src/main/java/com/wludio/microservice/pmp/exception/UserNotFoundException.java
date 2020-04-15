package com.wludio.microservice.pmp.exception;

import static java.lang.String.format;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException(String msg, Object...  params) {
        super(format(msg, params));
    }
}
