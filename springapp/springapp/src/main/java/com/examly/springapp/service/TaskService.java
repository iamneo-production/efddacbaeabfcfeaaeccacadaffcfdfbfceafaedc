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

    public Task getTaskId(Integer taskid) {
        Optional<Task> optional = taskRepository.findById(taskid);
		Task task = null;
		if (optional.isPresent()) {
			task = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + taskid);
		}
		return task;
	}  

	public void deleteTaskById(Integer taskid) {
		this.taskRepository.deleteById(taskid);
	}
}
