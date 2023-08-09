package com.examly.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.TaskService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class TaskController {

    private TaskService taskService;

    @GetMapping("/getTask")
    public List<Task> getTask()
    {
        return taskService.getAllTasks();
    }

    @PostMapping("/saveTask")
    public Task addTask(@RequestBody Task task)
    {
        return taskService.saveTask(task); 
    } 
}
