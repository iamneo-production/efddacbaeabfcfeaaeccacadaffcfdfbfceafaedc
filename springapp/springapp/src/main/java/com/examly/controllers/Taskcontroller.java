package com.examly.controllers;

import java.util.List;

import com.examly.model.Task;
import com.examly.services.Taskservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class Taskcontroller {
    
    private Taskservice taskservice;

    @GetMapping("/task")
    public List<Task> getTask()
    {
        return taskservice.getTasks();
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task)
    {
        return taskservice.save(task); 
    }

    @PutMapping("/task/{id}")
    public Task addTask(@RequestBody Task taskPara,@PathVariable Long id)
    {
        if(taskservice.existById(id)){
            Task task=taskservice.getTaskById
        }
    }
}
