package com.examly.springapp.controllers;


@RestController
@RequestMapping("/taskmgmt")
public class TaskController {

    private Taskservice taskservice;

    @GetMapping
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
