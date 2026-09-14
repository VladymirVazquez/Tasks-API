package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TasksRequest {
  @NotBlank  
  @Size(min = 3, max = 50)
  private String name;
  @NotNull 
  @Positive 
  private Integer userId;

  public TasksRequest(){

  }

  public int getUserId(){
    return userId;
  }

  public String getName(){
    return name;
  }

  public void setUserId(int userId){
    this.userId = userId;
  }

  public void setName(String name){
    this.name = name;
  }
}
