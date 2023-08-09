package com.examly.springapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@Service
public class TaskService 
{
    @Autowired
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) 
    {
        this.taskRepository = taskRepository;
    }

    public void addTask(String taskHolderName, Date taskDate, String taskName,String taskStatus ) 
    {
        taskRepository.save(new Task(taskHolderName, taskDate, taskName, taskStatus));
    }

    public void deleteTask(long taskId) 
    {
        Optional < Task > task = taskRepository.findById(taskId);
        if (task.isPresent()) {
            taskRepository.delete(task.get());
        }
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public Task chagngeStatus(Long id, Task task) 
    {
        Task updatedTask = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task id: " + id));
        updatedTask.setTaskStatus(task.getTaskStatus());
        return taskRepository.save(updatedTask);
    }

    public List<Task> getAllTasks() 
    {
        return taskRepository.findAll();
    }
}


