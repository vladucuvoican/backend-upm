package com.wludio.microservice.pmp.exception;

import static java.lang.String.format;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String msg) {
        super(msg);
    }

    public ItemNotFoundException(String msg, Object...  params) {
        super(format(msg, params));
    }
}
