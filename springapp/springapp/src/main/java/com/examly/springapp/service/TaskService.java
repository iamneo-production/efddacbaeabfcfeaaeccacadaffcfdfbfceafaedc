package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService 
{
    @Autowired
    private TaskRepository taskRepository;

    public Task saveTasks(Task task) 
    {
        task.setTaskHolderName("Gowthaman M");
        task.setTaskName("Spring Projects");
        task.setTaskStatus("In Progress");
        return taskRepository.save(task);
    }
      
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    
}
