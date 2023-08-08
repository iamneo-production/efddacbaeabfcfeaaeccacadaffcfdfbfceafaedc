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
@RequestMapping("/api/v1/tasks")
public class Taskcontroller {
    
    @Autowired
    private Taskservice taskservice;

    @GetMapping("/alltasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskservice.getAllTask());
    }
    @PostMapping("/saveTask")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskservice.createNewTask(task));
    }
    @PutMapping("/changeStatus/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        task.setTaskId(taskId);
        return ResponseEntity.ok(taskservice.updateTask(task));
    }

    @GetMapping("/getTask/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId)
    {
        return ResponseEntity.ok(taskservice.findTaskById(taskId));
    }
    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Boolean> getAllTasks(@PathVariable Long taskId) {
        taskservice.deleteTask(taskId);
        return ResponseEntity.ok(true);
    }
}
