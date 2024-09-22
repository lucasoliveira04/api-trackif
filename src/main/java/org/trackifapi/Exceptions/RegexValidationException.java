package org.trackifapi.Exceptions;

public class RegexValidationException extends RuntimeException {
    public RegexValidationException(String message) {
        super(message);
    }
}