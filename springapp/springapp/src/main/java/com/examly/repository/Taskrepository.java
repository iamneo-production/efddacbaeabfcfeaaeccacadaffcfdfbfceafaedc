package com.examly.repository;

import com.examly.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Taskrepository extends JpaRepository<Task,Long>{
    
    @Query(value="Select * from task order by taskDate desc",nativeQuery = true)
    public List<Task> getAllTaskTaskDateDesc();
}
