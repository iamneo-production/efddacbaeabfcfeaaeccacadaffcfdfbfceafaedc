package com.examly.services;

import com.examly.model.Task;
import java.util.List;
import org.springframework.stereotype.Service;
import com.examly.repository.Taskrepository;

@Service
public class Taskservice{

    private Taskrepository taskRepository;

    public Task saveTask(Task task) 
    {
        taskRepository.save(task);
        return task;
    }
    
}