package com.examly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.model1.task;

public interface Taskrepository extends JpaRepository<task,Long>{
    
}
