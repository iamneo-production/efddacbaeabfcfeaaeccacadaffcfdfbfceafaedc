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
      
    public List<Task> getTask() 
    {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    public Optional<Task> getTaskId(Long taskid){
        return taskRepository.findById(taskid);
    }

	public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }

    public void changeStatus(Long taskid) {'
    
    }
}
