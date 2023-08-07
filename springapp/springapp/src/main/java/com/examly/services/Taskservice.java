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
    
    @Transactional(readOnly =true)
    public List<Task> getAllTasks()
    {
        return taskRepository.getAllTaskTaskDateDesc();
    }

    @Transactional
    public Task saveTask(Task task) {
        return taskRepository.saveAndFlush(task);
    }

    @Transactional(readOnly =true)
    public boolean existById(Long id){
        return taskRepository.existsById(id);
    }

    @Transactional(readOnly =true)
    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public void delete(Long id)
    {
        taskRepository.delete(id);
    }

}
