package com.examly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examly.model.Task;
import com.examly.repository.Taskrepository;

@Service
public class Taskservice{
    
    private Taskrepository taskRepository;

    public Taskrepository getTaskRepository() {
        return taskRepository;
    }

    public void setTaskRepository(Taskrepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    public Task updateTask(Long id,Task task)
    {
        Task updatedTask = taskRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid task id:" +id));
        updatedTask.setTaskStatus(task.);
    }   

    public Optional<Task> getTaskById(Long id)
    {
        return taskRepository.findById(id);
    }

    public void delete(Long id)
    {
        taskRepository.delete(id);
    }

    public Task updateTask(Long id, Task task) {
        return null;
    }

    public void deleteTask(Long id) {
    }

}
