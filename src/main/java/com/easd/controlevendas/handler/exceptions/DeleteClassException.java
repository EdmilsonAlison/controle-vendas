package com.easd.controlevendas.handler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DeleteClassException extends RuntimeException {

    public DeleteClassException(String message) {
        super(message);
    }
}
