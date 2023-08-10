package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService 
{
    @Autowired
    private TaskRepository taskRepository;
      
    @Transactional(readOnly = true)
    public List<Task> getTasks() 
    {
        return taskRepository.findAll();
    }    
}
