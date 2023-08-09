package com.examly.springapp.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService 
{
    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask() {
        Task task = new Task();
        task.setTaskHolderName("Gowthaman M");
        task.setTaskDate("2021/04/15");
        task.setTaskName("Spring Projects");
        task.setTaskStatus("In Progress");
        taskRepository.save(task);
        return taskRepository.save(task);
    }
      
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    
}
