package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService 
{
    @Autowired
    private TaskRepository taskRepository;
      
    public List<Task> getTasks() 
    {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    public Optional<Task> getTaskId(Integer taskId){
        return taskRepository.findById(taskId);
    }

	public void deleteTask(Integer taskId){
        taskRepository.deleteById(taskId);
    }
}
