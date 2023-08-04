package com.examly.repository;

import com.examly.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Taskrepository extends JpaRepository<Task,Long>{
    

}
