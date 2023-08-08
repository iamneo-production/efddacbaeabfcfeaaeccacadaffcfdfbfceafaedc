package com.examly.repository;

import com.examly.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Taskrepository extends JpaRepository<Task,Long>{
}
