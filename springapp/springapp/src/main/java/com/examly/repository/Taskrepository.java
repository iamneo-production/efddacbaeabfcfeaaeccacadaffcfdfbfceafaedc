package com.examly.repository;

import java.util.Optional;

import com.examly.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Taskrepository extends JpaRepository<Task,Long>{
    
}
