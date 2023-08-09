package com.examly.springapp.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@Service
public class TaskService 
{
    @Autowired
    private TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) 
    {
        this.taskRepository = taskRepository;
    }

    public void addTask(String taskHolderName, Date taskDate, String taskName,String taskStatus ) 
    {
        taskRepository.save(new Task(taskHolderName, taskDate, taskName, taskStatus));
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() 
    {
        return taskRepository.findAll();
    }

    
}
