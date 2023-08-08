package com.examly.springapp.repository;

import java.util.List;

import com.examly.springapp.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{
    public Task findByTask(String task);
    public List<Task> findAll();
    public Task getById(Long id);
}
