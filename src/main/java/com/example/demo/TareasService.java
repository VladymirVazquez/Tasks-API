package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service 
public class TareasService {

  private TareasRepository tareasRepository;
  
  public TareasService(TareasRepository tareasRepository){
    this.tareasRepository = tareasRepository;

  }

  public List<Tarea> findAll(){
    return tareasRepository.findAll();
  }

  public Optional<Tarea> getTareaById(int id){
    return tareasRepository.findById(id);
  }

  public Tarea postTarea(Tarea tarea){
    if(tarea.getName().isBlank()){
      throw new IllegalArgumentException("Name is blank");
    }
    if(tarea.getName().length() < 3){
      throw new IllegalArgumentException("Name too short");
    }
    return tareasRepository.save(tarea);
  }

  public Tarea putTarea(int id, Tarea tarea){

    if(tarea.getName().isBlank()){
      throw new IllegalArgumentException("Name is blank");
    }
    if(tarea.getName().length() < 3){
      throw new IllegalArgumentException("Name too short");
    }
    
    Tarea t = tareasRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id was not found"));

    t.setName(tarea.getName());

    return tareasRepository.save(t);  
  }

  public void deleteTarea(int id){
    tareasRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id was not found"));

    tareasRepository.deleteById(id);
     
  }
}
