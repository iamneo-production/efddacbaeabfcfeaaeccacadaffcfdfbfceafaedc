package com.examly.springapp.controllers;

import java.util.List;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;
import com.examly.springapp.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/alltasks")
    public List<Task> alltasks()
    {
        return taskService.getAllTask();
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task)
    {
        return taskService.saveTasks(task);
    }
    

}
