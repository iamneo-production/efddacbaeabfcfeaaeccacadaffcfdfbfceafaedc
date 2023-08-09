package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.repository.TaskRepository;

@Service
public class TaskService 
{
    @Autowired
    private TaskRepository taskRepository;

    
}


