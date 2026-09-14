
package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class UserService {
  private UserRepository userRepository;

  public UserService(UserRepository userRepository ){
    this.userRepository = userRepository;
  }

  public List<User> getUsers(){
    return userRepository.findAll();
  }

  public User getUser(int id){
    User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user id was not found"));
    return user;
  }

  public User postUser(UserRequest userRequest){
    User user = new User();
    user.setName(userRequest.getName());
    return userRepository.save(user);
  }

  public User putUser(int id, UserRequest userRequest){
    
    User u = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user id was not found"));
    u.setName(userRequest.getName());
    return userRepository.save(u);
  }

  public void deleteUser(int id){
    userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user id was not found"));
    userRepository.deleteById(id);
  }
}
