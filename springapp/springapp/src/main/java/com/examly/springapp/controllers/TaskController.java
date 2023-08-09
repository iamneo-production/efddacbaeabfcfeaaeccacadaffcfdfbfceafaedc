package com.examly.springapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController 
{
    private TaskService taskService;

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        
        return ResponseEntity.ok(taskService.createNewTask(task));
    }
    


}