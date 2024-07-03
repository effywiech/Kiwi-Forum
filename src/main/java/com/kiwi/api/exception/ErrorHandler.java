package com.kiwi.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorValidationData>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<ErrorValidationData> errors = ex.getFieldErrors().stream()
                .map(ErrorValidationData::new)
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }

    private record ErrorValidationData(String field, String message) {
        public ErrorValidationData(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
