package com.examly.springapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;

@RestController
@RequestMapping(value = "/taskno")
public class TaskController 
{
    private TaskService taskService;

    @GetMapping
    public List<Task> getTask(){
        return taskService.getTasks();
    }


}