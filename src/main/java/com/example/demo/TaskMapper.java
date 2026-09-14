package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component 
public class TaskMapper {

  public TaskResponse toResponse(Task task){
    TaskResponse taskResponse = new TaskResponse(task.getId(), task.getName(), task.getUser().getId());
    return taskResponse;
  }

   public List<TaskResponse> toResponse(List<Task> tasks){
    List<TaskResponse> taskResponses = new ArrayList<>();
    for(Task task: tasks){
      taskResponses.add(toResponse(task));
    }
    return taskResponses;
  }
  
}
