package com.rashmi.springbootframework.exception;

public class EventPublishException extends RuntimeException {

    public EventPublishException(String message, Throwable throwable) {
        super(message, throwable);
    }

}