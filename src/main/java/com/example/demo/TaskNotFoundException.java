package com.example.demo;

public class TaskNotFoundException extends IllegalArgumentException{
  
  public TaskNotFoundException(String message){
    super(message);
  }
}
