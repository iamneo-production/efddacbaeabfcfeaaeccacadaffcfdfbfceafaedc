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

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/admin/addtask")
    public Task addtask(@RequestBody Task task){
        taskService.addtask(task);
        return task;
    }

    @GetMapping("/admin/getTask")
    public List<Task> getTask()
    {
        List<Task> task = taskService.getTask();
        return task;
    }


    @GetMapping("/admin/getTask/{taskId}")
    public Long getTaskId(@PathVariable Long taskId)
    {
        Task task = taskService.getTaskId(taskId);
        return taskId;
    }

    @GetMapping("/deleteTask/{taskid}")
    public void deleteTask(@PathVariable Long taskid){
        taskService.deleteTask(taskid);
}
}
