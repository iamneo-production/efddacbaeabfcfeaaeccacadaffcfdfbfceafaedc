package com.examly.services;

import java.util.List;
import com.examly.model1.task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    
    @Transactional(readOnly =true)
    public List<task> getTasks()
    {
        return taskRepository.findAll();
    }
}
