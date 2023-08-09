package com.examly.springapp.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class TaskController 
{
    @Autowired
    private TaskService taskService;
}
