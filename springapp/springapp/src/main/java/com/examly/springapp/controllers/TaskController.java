package com.examly.springapp.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;

@Controller
public class TaskController 
{
    @Autowired
    private TaskService taskService;


}