package com.examly.controllers;

import com.examly.model.Task;

import com.examly.services.Taskservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class Taskcontroller {

    @Autowired
    private Taskservice taskservice;

    @GetMapping("/")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task savedTask = taskservice.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task)
    {
        return taskservice.saveTask(task);
    }

    @GetMapping("/tasks/{taskId}") 
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) 
    Task task = taskService.getTask(taskId);
    if (task == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(task, HttpStatus.OK);
}

    
}