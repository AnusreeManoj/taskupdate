package com.example.taskupdate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.taskupdate.model.Task;
import com.example.taskupdate.repository.taskrepository;
import com.example.taskupdate.exception.UserNotFoundException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class taskcontroller{
    @Autowired
    private taskrepository taskRepository;
    @PostMapping("/task")
    Task newUser(@RequestBody Task newUser)
    {
        return taskRepository.save(newUser);
    }

  @GetMapping("/tasks") 
  List<Task> getAllTasks(){
    return taskRepository.findAll();
  }

@GetMapping("/task/{id}")
Task getUserById(@PathVariable Long id){
  return taskRepository.findById(id)
  .orElseThrow(()-> new UserNotFoundException(id));
}


@PutMapping("/task/{id}")
Task updateUser(@RequestBody Task newTask, @PathVariable Long id){
  return taskRepository.findById(id)
  .map(task->{
    task.setTaskname(newTask.getTaskname());
    task.setProjectname(newTask.getProjectname());
    task.setStatus(newTask.getStatus());
    task.setPercentagecompleted(newTask.getPercentagecompleted());
    task.setDate(newTask.getDate());
    task.setStatus(newTask.getStatus());
    task.setNotes(newTask.getNotes());
    return taskRepository.save(task);
  }).orElseThrow(()->new UserNotFoundException(id));
}
@DeleteMapping("/task/{id}")
String deleteUser(@PathVariable Long id){
  if(!taskRepository.existsById(id)){
    throw new UserNotFoundException(id);
  }
  taskRepository.deleteById(id);
  return "User with id  "+id+" deleted successfully.";
}
}
