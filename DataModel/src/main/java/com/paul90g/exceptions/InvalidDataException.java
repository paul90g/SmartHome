package com.paul90g.exceptions;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("unused")
@Slf4j
public class InvalidDataException extends RuntimeException {

    public InvalidDataException() {
        super();
    }

    public InvalidDataException(String s) {
        super(s);
        log.error(s);
    }

    public InvalidDataException(String s, Throwable throwable) {
        super(s, throwable);
        log.error("{}; {}", s, throwable.toString());
    }

}
