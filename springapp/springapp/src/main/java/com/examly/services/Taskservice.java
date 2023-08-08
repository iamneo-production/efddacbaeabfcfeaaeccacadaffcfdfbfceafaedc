package com.examly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.examly.model.Task;
import com.examly.repository.Taskrepository;

@Service
public class Taskservice{

    private Taskrepository taskRepository;

    public Taskservice(Taskrepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    public Task updateTask(Long taskId, Task task) {
        return taskRepository.save(task);
    }
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(id);
    }
}