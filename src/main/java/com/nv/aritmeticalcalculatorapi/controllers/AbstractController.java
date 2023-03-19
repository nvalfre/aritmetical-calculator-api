package com.nv.aritmeticalcalculatorapi.controllers;

import com.nv.aritmeticalcalculatorapi.domain.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public abstract class AbstractController {

    @ExceptionHandler(value = {Exception.class, IllegalArgumentException.class})
    public ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request){
        return ResponseEntity.badRequest()
                .body(
                        ApiError.builder()
                                .statusCode(HttpStatus.BAD_REQUEST.value())
                                .status(HttpStatus.BAD_REQUEST.getReasonPhrase())
                                .message(ex.getMessage())
                                .build()
                );
    }
}
