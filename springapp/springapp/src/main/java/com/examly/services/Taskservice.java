package com.examly.services;


import java.util.Optional;

import com.examly.model.Task;
import org.springframework.stereotype.Service;
import com.examly.repository.Taskrepository;

@Service
public class Taskservice{

    private Taskrepository taskRepository;

    public Task saveTask(Task task)
    {
        return taskRepository.save(task);
    }

    public boolean existById(Long taskId) 
    {
        return taskRepository.existsById(taskId);
    }
   
    public Optional<Task> getTaskById(Long taskId)
    {
        return taskRepository.findById(taskId);
    }
    
}