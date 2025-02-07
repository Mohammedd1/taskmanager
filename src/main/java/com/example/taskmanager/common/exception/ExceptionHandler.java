package com.example.taskmanager.common.exception;


import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ResponseWrapper<?>> handleException(Exception ex) {
//        ResponseWrapper<?> response = new ResponseWrapper<>(
//                HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                "An unexpected error occurred: " + ex.getMessage()
//        );
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ResponseWrapper<?>> handleIllegalArgumentException(IllegalArgumentException ex) {
//        ResponseWrapper<?> response = new ResponseWrapper<>(
//                HttpStatus.BAD_REQUEST.value(),
//                "Invalid request: " + ex.getMessage()
//        );
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
}
