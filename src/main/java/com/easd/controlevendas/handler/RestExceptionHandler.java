package com.easd.controlevendas.handler;

import com.easd.controlevendas.handler.error.ErrorMessage;
import com.easd.controlevendas.handler.exceptions.DeleteClassException;
import com.easd.controlevendas.handler.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handlerNotFoundException(NotFoundException exception){
        ErrorMessage errorMessage = new ErrorMessage("Not Found Categorie", exception.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DeleteClassException.class)
    public ResponseEntity<ErrorMessage> deleteClassException(DeleteClassException exception){
        ErrorMessage errorMessage = new ErrorMessage("Impossivel deletar"
                , exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
