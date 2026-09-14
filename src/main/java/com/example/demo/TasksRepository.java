package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TasksRepository extends JpaRepository <Task, Integer>{

  List<Task> findByUser(User user);

  List<Task> findByNameContaining(String name);

  List<Task> findByNameContainingAndUser(String name, User user);

  List<Task> findByNameContainingOrUser(String name, User user);
  
  @Query("SELECT t FROM Task t WHERE t.name = :name")
  List<Task> buscarPorNombre(@Param("name")String name);

  @Query("SELECT t FROM Task t WHERE t.name LIKE CONCAT('%', :name, '%')")
  List<Task> buscarPorPalabra(String name);

  @Query ("SELECT t FROM Task t WHERE t.name LIKE CONCAT('%', :name, '%') AND t.user = :user")
  List<Task> buscarPorPalabraAndUser(String name, User user); 
} 