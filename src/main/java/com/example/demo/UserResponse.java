package com.example.demo;

public class UserResponse {
  private int id;
  private String name;

  public UserResponse(int id, String name){
    this.name = name;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
