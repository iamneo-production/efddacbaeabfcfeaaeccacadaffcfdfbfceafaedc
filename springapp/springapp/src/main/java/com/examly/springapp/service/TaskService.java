package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService 
{
    private TaskRepository taskRepository;
      
    public List<Task> getAllTask() 
    {
        return taskRepository.findAll();
    }

    public Task saveTasks(Task task) 
    {
        return taskRepository.save(task);
    }

    
}
