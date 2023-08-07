package com.examly.controllers;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.examly.model.Task;
import com.examly.repository.Taskrepository;
import com.examly.services.Taskservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/tasks")
    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> saveTask(@RequestBody Task task)
    {
        taskRepository.save(task);
        return ResponseEntity.ok(task); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long)