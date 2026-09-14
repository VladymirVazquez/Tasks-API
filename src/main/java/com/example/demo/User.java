package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  @JsonManagedReference 
  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
  private List<Task> tasks;

  public User(){
  }

  public int getId(){
    return id;
  }
  
  public String getName(){
    return name;
  }

  public List<Task> getTasks(){
    return tasks;
  }

  public void setName(String name){
    this.name = name;
  }

  public void addTasks(Task task){
    tasks.add(task);
  }

}
