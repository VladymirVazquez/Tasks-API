package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class TasksService {

  private final UserRepository userRepository;
  private TasksRepository tasksRepository;
  
  
  public TasksService(TasksRepository tasksRepository, UserController usersController, UserRepository userRepository){
    this.tasksRepository = tasksRepository;
    this.userRepository = userRepository;

  }

  public List<Task> findAll(){
    return tasksRepository.findAll();

  }

  public Task getTaskById(int id){
    return tasksRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("task Id not found"));
  }

  public List<Task> findTasksByUser(int userId){
    User user = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("user Id was not found"));
    return tasksRepository.findByUser(user);
  }

  public List<Task> findTasksByName(String name) {
    return tasksRepository.findByNameContaining(name);
  }

  public List<Task> findByNameContainingAndUser(String name, int userId){
    return tasksRepository.findByNameContainingAndUser(name, userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("user id was not found")));
  }

  public List<Task> findByNameOrUser(String name, int userId){
    return tasksRepository.findByNameContainingOrUser(name, userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user id was not found")));
  }

  public Task postTask(TasksRequest tasksRequest){
    User user = userRepository.findById(tasksRequest.getUserId()).orElseThrow(()-> new UserNotFoundException("user id was not found"));
    Task task = new Task();
    task.setName(tasksRequest.getName());
    task.setUser(user);
    return tasksRepository.save(task);
    
  }


  public Task putTask(int id, TasksRequest tasksRequest){
    Task task = tasksRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("task Id was not found"));
    User user = userRepository.findById(tasksRequest.getUserId()).orElseThrow(() -> new UserNotFoundException("user id was not found"));

    task.setName(tasksRequest.getName());
    task.setUser(user);
    return tasksRepository.save(task);
  }

  public void deleteTask(int id){
    tasksRepository.findById(id).orElseThrow(()-> new TaskNotFoundException("task Id was not found"));

    tasksRepository.deleteById(id);
     
  }
}
