package com.ingensi.labs.awesome.core;

/**
 * Main exception.
 */
public class AwesomeException extends Exception {
    public AwesomeException() {
    }

    public AwesomeException(String message) {
        super(message);
    }

    public AwesomeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AwesomeException(Throwable cause) {
        super(cause);
    }

    public AwesomeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
