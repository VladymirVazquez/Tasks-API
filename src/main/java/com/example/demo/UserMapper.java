package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component 
public class UserMapper {
  
  public UserResponse toResponse(User user){
    return new UserResponse(user.getId(), user.getName());
  }

  public List<UserResponse> toResponse(List<User> users){
    List<UserResponse> userResponses = new ArrayList<>();
    for(User user : users){
      userResponses.add(toResponse(user));
    }
    return userResponses;
  }
}
