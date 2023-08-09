package com.examly.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@RestController
@RequestMapping("/api/v1")
public class TaskController 
{
    @Autowired
    private TaskRepository taskRepository;
    

    @GetMapping("/taskproject")
    public List<Task> getTask(){
        return taskRepository.findAll();
    }
    
    @PostMapping("/task")
    public Task addTask(@RequestBody Task task)
    {
        return taskRepository.save(task); 
    }
}