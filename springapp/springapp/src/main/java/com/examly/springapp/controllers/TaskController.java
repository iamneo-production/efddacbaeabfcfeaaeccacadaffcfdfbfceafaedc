package com.examly.springapp.controllers;

import java.util.List;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private TaskService taskService;
    private TaskRepository taskRepository;

    @GetMapping("/getTask")
    public List<Task> findAll()
    {
        return taskRepository.findAll();
    }

    @PostMapping("/saveTask")
    public Task save(@RequestBody Task task)
    {
        return taskRepository.save(task);
    }

}
