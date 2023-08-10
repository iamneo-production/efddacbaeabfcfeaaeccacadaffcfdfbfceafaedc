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

    @GetMapping("/create")
    public String createTask(Task task) {
        task.addAttribute("task", new Task());
        return "task/create";
    }
}