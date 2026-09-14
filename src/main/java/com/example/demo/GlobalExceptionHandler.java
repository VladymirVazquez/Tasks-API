package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {
  
  @ExceptionHandler(TaskNotFoundException.class)
  public ResponseEntity<?> handle(TaskNotFoundException e){
      return ResponseEntity.status(404).body(new ErrorResponse(404, e.getMessage()));
  
  } 

  @ExceptionHandler (UserNotFoundException.class)
  public ResponseEntity<?> handle(UserNotFoundException e){
    return ResponseEntity.status(404).body(new ErrorResponse(404, e.getMessage()));
  }

  @ExceptionHandler (IllegalArgumentException.class)
  public ResponseEntity<?> handle(IllegalArgumentException e){
    return ResponseEntity.status(400).body(new ErrorResponse(400,e.getMessage()));
  } 

  @ExceptionHandler (MethodArgumentNotValidException.class)
  public ResponseEntity<?> handle(MethodArgumentNotValidException e){
    List<String> errors = new ArrayList<>();

    for(FieldError error : e.getBindingResult().getFieldErrors() ){
      errors.add(error.getDefaultMessage());
 
    }
    
    return ResponseEntity.status(400).body(new ErrorResponse(400, errors.toString()));
  }

  
}
