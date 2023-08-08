package com.examly.springapp.controllers;

import java.util.List;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/tasks")
public class TaskController
{

    @Autowired
    private TaskService taskService;

    @GetMapping("/alltasks")
    public ResponseEntity<List<Task>> getAllTasks() 
    {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Boolean> getAllTasks(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }
}