package com.examly.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/taskmgmt")
public class TaskController {

    private TaskService taskService;

    @GetMapping("/")
    public List<Task> getTask()
    {
        return taskservice.getAllTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task)
    {
        return taskservice.saveTask(task); 
    } 
}
