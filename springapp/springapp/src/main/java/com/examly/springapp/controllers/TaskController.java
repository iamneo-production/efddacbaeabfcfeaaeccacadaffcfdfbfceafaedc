package com.examly.springapp.controllers;

import java.util.List;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public List<Task> getTask()
    {
        return taskService.getTasks();
    }

    @PostMapping("/saveTask")
    public Task addTask(@RequestBody Task task) {
        return taskService.save(task);
    }


    

}
