package com.examly.springapp.controllers;


@RestController
@RequestMapping("/api/v1")
public class TaskController {

    private Taskservice taskservice;

    @GetMapping("/alltasks")
    public List<Task> getTask()
    {
        return taskservice.getAllTasks();
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task)
    {
        return taskservice.saveTask(task); 
    } 
}
