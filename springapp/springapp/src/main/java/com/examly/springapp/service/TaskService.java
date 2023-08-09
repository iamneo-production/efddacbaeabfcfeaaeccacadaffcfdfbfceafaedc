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

    public Task createNewTask(Task task) {
        Task task = new Task();
        task.setTName("Task 1");
        task.setDescription("This is a task");
        task.setStatus("To Do");
        task.setDueDate(LocalDate.now().plusDays(1));
        taskRepository.save(task);
        return taskRepository.save(task);
    }
      
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    
}
