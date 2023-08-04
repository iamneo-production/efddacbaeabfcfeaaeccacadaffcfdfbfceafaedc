package com.examly.controllers;

import com.examly.services.Taskservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@AllArgsConstructor
public class Taskcontroller {
    
    private Taskservice taskservice;

    public List<task> getTask()
    {
        return task

    }
}
