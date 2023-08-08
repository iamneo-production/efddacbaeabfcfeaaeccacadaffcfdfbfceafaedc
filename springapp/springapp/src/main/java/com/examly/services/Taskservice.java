package com.examly.services;

import java.util.List;

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

    public List<Task> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks;
    }
    public Task getTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        return task;
    }
    
}