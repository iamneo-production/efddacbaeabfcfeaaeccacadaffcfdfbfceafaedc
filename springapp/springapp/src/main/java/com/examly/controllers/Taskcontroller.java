package com.examly.controllers;

import java.util.List;

import com.examly.model.Task;
import com.examly.repository.Taskrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class Taskcontroller {
    
    @Autowired
    private Taskrepository taskrepository;

    @GetMapping("/alltasks")
    public List<Task> getAllTasks()
    {
        return taskrepository.findAll();
    }
    }
