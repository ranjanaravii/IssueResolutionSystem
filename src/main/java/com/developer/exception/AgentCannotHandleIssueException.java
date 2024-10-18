package com.developer.exception;

public class AgentCannotHandleIssueException extends RuntimeException {
    public AgentCannotHandleIssueException(String message) {
        super(message);
    }
}
