package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
  private final UserService userService;
  private final UserMapper userMapper;

  public UserController(UserService userService, UserMapper userMapper){
    this.userService = userService;
    this.userMapper = userMapper;
  }

  @GetMapping("/users")
  public ResponseEntity<List<UserResponse>> getUsers() {
    List<User> users =  userService.getUsers();
      return ResponseEntity.ok(userMapper.toResponse(users));
  }
  

  @GetMapping("/users/{id}")
  public ResponseEntity<UserResponse> getUser(@PathVariable int id) {
    User user = userService.getUser(id); 
    return ResponseEntity.ok(userMapper.toResponse(user));
  }

  @PostMapping("/users")
  public ResponseEntity<UserResponse> postUser(@Valid @RequestBody UserRequest userRequest) {
    User user = userService.postUser(userRequest);
    return ResponseEntity.status(201).body(userMapper.toResponse(user));
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<UserResponse> putUser(@PathVariable int id, @Valid @RequestBody UserRequest userRequest) {
    User user = userService.putUser(id, userRequest);
      return ResponseEntity.ok(userMapper.toResponse(user));
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable int id){
    userService.deleteUser(id);
    return ResponseEntity.noContent().build();
  }
}
