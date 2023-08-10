package com.examly.springapp.controllers;

import java.util.*;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping

public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/saveTask")
    public List<Task> getTask()
    {
        return taskService.getTasks();
    }

    @PostMapping("/saveTask")
    public Task addtask(@RequestBody Task task){
        taskService.saveTask(task);
        return task;
    }

    @GetMapping("/alltasks")
    public List<Task> getallTask()
    {
        return taskService.getAllTasks();
    }

    @GetMapping("/getTask")
    public Task getTaskId(@PathVariable Long taskId)
    {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/deleteTask")
    public void deleteTask(@PathVariable Long taskid){
        taskService.deleteTask(taskid);
    }
}