package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import com.examly.springapp.model.Task;

public interface TaskRepository extends JpaRepository < Task, Long > 
{   
    public Task findByTask(String task);
    public List<Task> findAll();
}

