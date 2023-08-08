package com.examly.controllers;

import java.util.List;
import java.util.Optional;
import com.examly.model.Task;
import com.examly.repository.Taskrepository;
import com.examly.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/task")
public class Taskcontroller {
    
    @Autowired
    private Taskrepository taskRepository;
    private Taskservice taskservice;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        Task savedTask = taskservice.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("/alltasks")
    public List<Task> alltasks() {
        return taskRepository.findAll();
    }
    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
    @PutMapping("/changeStatus/{id}")
    public Task changeStatus(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/getTask")
    public Optional<Task> getTask(@PathVariable Long taskId)
    {
        return taskRepository.findById(taskId);
    }
    @DeleteMapping("/deleteTask")
    public void deleteTask(@PathVariable Long taskId) 
    {
        taskRepository.deleteById(taskId);
    }
}
