package com.examly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
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

    public boolean existById(Long id) {
        return taskRepository.existsById(id);
    }

    public Task changeStatus(Long id,Task task)
    {
        Task updatedTask = taskRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid task id:" +id));
        updatedTask.setTaskStatus(task.getTaskStatus());
        return taskRepository.save(updatedTask);
    }   

    public Optional<Task> getTaskById(Long id)
    {
        return taskRepository.findById(id);
    }

    public void deleteTask(Long id)
    {
        return taskRepository.deleteById(id);
    }

}
