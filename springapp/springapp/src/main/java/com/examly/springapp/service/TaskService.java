package com.examly.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.examly.repository.TaskRepository;
import com.examly.model.Task;

@Service
public class TaskService 
{
    @Autowired
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) 
    {
        this.taskRepository = taskRepository;
    }
    public Task createTask(Task task) 
    {
        return taskRepository.save(task);
    }
    public List<Task> alltasks() 
    {
        return taskRepository.findAll();
    }
    public Task getTask(Long taskId) 
    {
        return taskRepository.findById(taskId).orElse(null);
    }
    public Task updateTask(Long taskId, Task task) {
        Task existingTask = taskRepository.findById(taskId).orElse(null);
        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        return taskRepository.save(existingTask);
    }
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}

