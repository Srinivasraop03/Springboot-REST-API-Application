package com.restapi.exception;

import com.restapi.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {

    @ExceptionHandler(value = { CloudVendorNotFoundException.class })
    public ResponseEntity<Object> handleCloudVendorNotFoundException(
            CloudVendorNotFoundException cloudVendorNotFoundException) {
        return ResponseHandler.responseBuilder(
                cloudVendorNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND,
                null);
    }

    @ExceptionHandler(value = { org.springframework.web.bind.MethodArgumentNotValidException.class })
    public ResponseEntity<Object> handleValidationExceptions(
            org.springframework.web.bind.MethodArgumentNotValidException ex) {
        java.util.Map<String, String> errors = new java.util.HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((org.springframework.validation.FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseHandler.responseBuilder("Validation Failed", HttpStatus.BAD_REQUEST, errors);
    }
}
