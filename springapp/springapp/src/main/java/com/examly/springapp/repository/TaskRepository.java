package com.examly.repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> 
{
    List<Task> findAllByTaskHolderName(Task taskHolderName);
}
    
