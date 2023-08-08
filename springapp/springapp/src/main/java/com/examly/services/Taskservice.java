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
        Task savedTask = taskRepository.save(task);
        savedTask.setTaskId(task.getTaskId());
        return savedTask;
    }

    public Optional<Task> getTask(Long taskId) {
        return taskRepository.getTask(taskId);
    }
    
}