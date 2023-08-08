package com.examly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.model.Task;
import com.examly.repository.Taskrepository;

@Service
public class Taskservice{

    @Autowired
    private Taskrepository taskRepository;

    public Task createNewTask(Task task)
    {
        return taskRepository.save(task);
    }

    public List<Task> getAllTask()
    {
        return taskRepository.findAll();
    }

    public Task findTaskById(Long taskId)
    {
        return taskRepository.getById(taskId);
    }

    public void deleteTask(Long taskId)
    {
        taskRepository.deleteById(taskId);
    }

    public Task updateTask(Task task)
    {
        return taskRepository.save(task);
    }

   

}