package com.example.demo.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoggedRuntimeException extends RuntimeException {
    public LoggedRuntimeException(String message) {
        super(message);
        log.error("{} : {}", this.getClass().getSimpleName(), message);
    }
}
