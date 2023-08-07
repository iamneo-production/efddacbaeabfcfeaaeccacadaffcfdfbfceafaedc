package com.examly.controllers;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.examly.model.Task;
import com.examly.services.Taskservice;
import com.examly.repository.Taskrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class Taskcontroller {
    
    @Autowired
    private Taskservice taskservice;
    private Taskrepository taskRepository;

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task createdTask = taskservice.addTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PostMapping("/saveTask")
public ResponseEntity<Task> saveTask(@RequestBody Task task) {
    taskRepository.save(task);
    return ResponseEntity.ok(task);
}

    @GetMapping("/deleteTask")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskservice.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/alltasks")
    public List<Task> alltasks()
    {
        return taskRepository.findAll();
    }

    @GetMapping("/getTask")
    public Task getTask(@PathVariable Long id)
    {
        return taskRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Task not found with id:" +id)); 
    }
}


