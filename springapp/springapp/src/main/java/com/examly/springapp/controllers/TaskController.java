package com.examly.springapp.controllers;

import com.examly.springapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

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
