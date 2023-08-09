package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@Service
public class TaskService 
{
    @Autowired
    private TaskRepository taskRepository;
    
    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }
      
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    
}


