package com.examly.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@RestController
@RequestMapping("/taskproject")
public class TaskController 
{
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

}