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
@RequestMapping("/task")
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

    @PostMapping("/tasks/add")
public ResponseEntity<Task> addTask(@RequestBody Task task) {
    Task savedTask = taskService.saveTask(task);
    return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
}

}