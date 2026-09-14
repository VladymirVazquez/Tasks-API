package com.example.demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UserRequest{
  @NotBlank 
  @Size(min= 3, max=50)
  private String name;
  private Integer id;

  public String getName(){
    return name;
  }
  
  public int getId(){
    return id;
  }
  
  public void setUserName(String name){
    this.name = name;
  }

}