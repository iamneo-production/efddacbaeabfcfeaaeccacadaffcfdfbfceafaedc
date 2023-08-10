package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taskpro")
public class Task 
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int taskId;
    private String taskHolderName;
    private Long taskDate;
    private String taskName;

    private String taskStatus;

    public Task(String taskHolderName, Long taskDate, String taskName,String taskStatus) 
    {
        super();
        this.taskHolderName = taskHolderName;
        this.taskDate = taskDate;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }

    public int getTaskId() 
    {
        return taskId;
    }

    public void setTaskId(int taskId) 
    {
        this.taskId = taskId;
    }

    public String getTaskHolderName() 
    {
        return taskHolderName;
    }

    public void setTaskHolderName(String taskHolderName) 
    {
        this.taskHolderName = taskHolderName;
    }

    public Long getTaskDate() 
    {
        return taskDate;
    }

    public void setTaskDate(Long taskDate) 
    {
        this.taskDate = taskDate;
    }

    public String getTaskName() 
    {
        return taskName;
    }

    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskStatus() 
    {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus)
    {
        this.taskStatus = taskStatus;
    }

}


