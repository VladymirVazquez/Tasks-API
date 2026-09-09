package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController 
public class TareasController {
  private final TareasService tareasService;

  public TareasController(TareasService tareasService){
    this.tareasService = tareasService;
  }


  @GetMapping("/Tareas/{id}")
  public ResponseEntity<Tarea> getTareaById(@PathVariable int id) {

      Optional<Tarea> tarea = tareasService.getTareaById(id);

      if(tarea.isPresent()){
        return ResponseEntity.ok(tarea.get());
      }else{
        return ResponseEntity.notFound().build();
      }
  }

  @GetMapping("/tareas")
  public ResponseEntity<List<Tarea>> getAllTareas() {
      return ResponseEntity.ok(tareasService.findAll());
  }
  

  @PostMapping("/tareas")
  public ResponseEntity<?> postTarea(@RequestBody Tarea tarea) {
    try{
    Tarea t = tareasService.postTarea(tarea);
    return ResponseEntity.status(201).body(t);
    } catch (IllegalArgumentException e){
      String error = e.getMessage();
      return ResponseEntity.status(400).body(error);
    }
  }
  
  @PutMapping("/tareas/{id}")
  public ResponseEntity<?> putTarea(@PathVariable int id, @RequestBody Tarea tarea) {
    try{
      Tarea t = tareasService.putTarea(id, tarea);
      return ResponseEntity.ok(t);

    } catch(IllegalArgumentException e){
      String error = e.getMessage();
      
      if(error.equals("Id was not found")){
        return ResponseEntity.status(404).body(error);
      }
      return ResponseEntity.status(400).body(error);
    }
  }

  @DeleteMapping("/tareas/{id}")
    public ResponseEntity<String> deleteTarea(@PathVariable int id){
      try{
      tareasService.deleteTarea(id);
      return ResponseEntity.noContent().build();
      }catch(IllegalArgumentException e){
        String error = e.getMessage();
        return ResponseEntity.status(404).body(error);
      }
     

    }
  
  
}
