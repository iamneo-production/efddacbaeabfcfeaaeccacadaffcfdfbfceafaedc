package com.examly.springapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

@Service
public class TaskService{

    @Autowired
    private TaskRepository taskRepository;

    public List < Task > getTaskByTaskHolderName(String taskHolderName) {
        return taskRepository.findByTaskHolderName(taskHolderName);
    }

    public Optional < Task > getTaskById(long taskId) {
        return taskRepository.findById(taskId);
    }

    public void chagngeStatus(Task task) {
        taskRepository.save(task);
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
}
