package com.examly.springapp.controllers;

import java.util.List;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task)
    {
        taskService.saveTasks(task);
        return task;
    }

    @GetMapping("/alltasks")
    public List<Task> alltasks()
    {
        return taskService.getAllTask();
    }
    

}
