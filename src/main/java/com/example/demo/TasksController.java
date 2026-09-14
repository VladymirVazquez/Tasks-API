package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController 
public class TasksController {
  private final TasksService tasksService;
  private final TaskMapper taskMapper;

  public TasksController(TasksService tasksService, TaskMapper taskMapper){
    this.tasksService = tasksService;    
    this.taskMapper = taskMapper;

  }

  @GetMapping("/tasks/{id}")
  public ResponseEntity<TaskResponse> getTaskById(@PathVariable int id) {
    Task task = tasksService.getTaskById(id);
    return ResponseEntity.ok(taskMapper.toResponse(task));

  }

  @GetMapping("/tasks")
  public ResponseEntity<List<TaskResponse>> getAllTasks() {
    List<Task> tasks = tasksService.findAll();
    return ResponseEntity.ok(taskMapper.toResponse(tasks));
  }

  @GetMapping("/tasks/user/{userId}")
  public ResponseEntity<List<TaskResponse>> findTasksByUser(@PathVariable int userId) {
    List<Task> tasks = tasksService.findTasksByUser(userId);
    return ResponseEntity.ok(taskMapper.toResponse(tasks));

  }

  @GetMapping(value = "/tasks", params = "name")
  public ResponseEntity<List<TaskResponse>> findTasksByName(@RequestParam String name) {
    List<Task> tasks =  tasksService.findTasksByName(name);
    return ResponseEntity.ok(taskMapper.toResponse(tasks));
  }

  @GetMapping(value = "/tasks", params = {"name","userId"})
  public ResponseEntity<List<TaskResponse>> getTasksByNameAndUser(@RequestParam String name, @RequestParam int userId) {
    List<Task> tasks = tasksService.findByNameContainingAndUser(name, userId);
    return ResponseEntity.ok(taskMapper.toResponse(tasks));
  }

  @GetMapping(value = "/tasks/search-or", params = {"name", "userId"})
  public ResponseEntity<List<TaskResponse>> findByNameOrUser(@RequestParam String name,@RequestParam int userId) {
    List<Task> tasks = tasksService.findByNameOrUser(name, userId);
    return ResponseEntity.ok(taskMapper.toResponse(tasks));
  }
  
  @PostMapping("/tasks")
  public ResponseEntity<TaskResponse> postTask(@Valid @RequestBody TasksRequest tasksRequest) { 
    Task task = tasksService.postTask(tasksRequest);
    return ResponseEntity.status(201).body(taskMapper.toResponse(task));
  }
  
  @PutMapping("/tasks/{id}")
  public ResponseEntity<TaskResponse> putTask(@PathVariable int id, @Valid @RequestBody TasksRequest tasksRequest) {
      Task task = tasksService.putTask(id, tasksRequest);
      return ResponseEntity.ok(taskMapper.toResponse(task));
  }

  @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id){
      tasksService.deleteTask(id);
      return ResponseEntity.noContent().build();

    }

}
