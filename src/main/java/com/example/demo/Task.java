
package com.example.demo; 

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity 
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  @JsonBackReference 
  @ManyToOne 
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

 

  public Task(){

  }

  public int getId(){
    return id;
  }

  public String getName(){
    return name;
  }
  
  public User getUser() {
    return user;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setUser(User user){
    this.user = user;
  }
  
}
