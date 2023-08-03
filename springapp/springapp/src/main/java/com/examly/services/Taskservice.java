package com.examly.services;

import java.util.List;
import com.examly.model1.task;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Taskservice{
    
    private Taskrepository taskRepository;

    public Taskrepository getTaskRepository() {
        return taskRepository;
    }

    public void setTaskRepository(Taskrepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    @Transactions(readOnly =true)
    public List<task> getTasks()
    {
        return taskRepository.findAll();
    }
}
