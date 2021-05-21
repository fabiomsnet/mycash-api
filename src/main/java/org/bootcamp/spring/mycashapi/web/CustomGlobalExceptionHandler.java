package org.bootcamp.spring.mycashapi.web;

import org.bootcamp.spring.mycashapi.exception.UsuarioException;
import org.bootcamp.spring.mycashapi.web.dto.error.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMensagem("Erro de validação");
        apiError.addValidationErrors(ex.getFieldErrors());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<ApiError> handleUsuarioException(UsuarioException exception) {
        var apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMensagem(exception.getMessage());

        return ResponseEntity
                .status(apiError.getStatus())
                .body(apiError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleUsuarioException(EntityNotFoundException exception) {
        var apiError = new ApiError(HttpStatus.NOT_FOUND);
        apiError.setMensagem("Recurso não encontrado");

        return ResponseEntity
                .status(apiError.getStatus())
                .body(apiError);
    }
}
