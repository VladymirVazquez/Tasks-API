package com.example.demo;

public class UserNotFoundException extends IllegalArgumentException{
  
  public UserNotFoundException(String message){
    super(message);
  }
  
}
