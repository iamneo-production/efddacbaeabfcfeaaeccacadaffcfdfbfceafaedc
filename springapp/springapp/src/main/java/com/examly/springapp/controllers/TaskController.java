package com.examly.springapp.controllers;

import java.util.List;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin(origins = "https://8080-efddacbaeabfcfeaaeccacadaffcfdfbfceafaedc.project.examly.io")
public class TaskController {

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
