package com.developer.exception;

public class InvalidIssueTypeException extends RuntimeException {
    public InvalidIssueTypeException(String message) {
        super(message);
    }
}
