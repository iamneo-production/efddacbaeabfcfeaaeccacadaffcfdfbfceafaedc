package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.examly.springapp.model.Task;


@Repository
public interface TaskRepository extends JpaRepository < Task, Long > 
{   
    public Task findByTask(String task);
    public List<Task> findAll();
}

