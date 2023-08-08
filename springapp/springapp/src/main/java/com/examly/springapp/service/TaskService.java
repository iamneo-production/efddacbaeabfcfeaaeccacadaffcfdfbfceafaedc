package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.repository.TaskRepository;
import com.examly.springapp.model.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService 
{
    @Autowired
    private TaskRepository taskRepository;
      
    public Task createNewTask(Task task) 
    {
        return taskRepository.save(task);
    }
      
    public List<Task> getAllTask() 
    {
        return taskRepository.findAll();
    }
      
    public Task findTaskById(Long id) 
    {
        return taskRepository.getById(id);
    }

    public void deleteTask(Task task) 
    {
        taskRepository.delete(task);
    }
      
    public Task updateTask(Task task) 
    {
        return taskRepository.save(task);
    }
      
}
