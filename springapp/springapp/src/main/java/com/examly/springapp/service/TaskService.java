package com.examly.service;

import org.springframework.stereotype.Service;
import com.examly.repository.TaskRepository;
import com.examly.model.Task;

@Service
public class TaskService 
{
    @Autowired
    private TaskRepository taskRepository;

}
