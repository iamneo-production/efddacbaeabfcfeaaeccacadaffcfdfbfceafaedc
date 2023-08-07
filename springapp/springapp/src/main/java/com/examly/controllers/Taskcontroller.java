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

    @GetMapping("/alltasks")
    public List<Task> alltasks() {
        return taskservice.getAllTasks();
    }
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskservice.createTask(task);
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskservice.updateTask(id, task);
    }
    @DeleteMapping("/deleteTask")
    public void deleteTask(@PathVariable Long id) {
        taskservice.deleteTask(id);
    }
}
