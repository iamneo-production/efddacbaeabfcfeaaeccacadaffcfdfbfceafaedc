package com.examly.springapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long taskId;
    
    private String taskHolderName;
    private Date taskDate;
    private String taskName;
    private String taskStatus;

    public Task(String taskHolderName,Date taskDate,String taskName,String taskStatus)
    {
        this.taskHolderName=taskHolderName;
        this.taskDate=taskDate;
        this.taskName=taskName;
        this.taskStatus=taskStatus;
    }

    public Long getTaskId()
    {
        return taskId;
    }

    public void setTaskId(Long taskId)
    {
        this.taskId=taskId;
    }

    public String getTaskHolderName()
    {
        return taskHolderName;
    }

    public void setTaskHolderName(String taskHolderName)
    {
        this.taskHolderName=taskHolderName;
    }

    public Date getTaskDate()
    {
        return taskDate;
    }

    public void setTaskDate(Date taskDate)
    {
        this.taskDate=taskDate;
    }

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName=taskName;
    }

    public String getTaskStatus()
    {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus)
    {
        this.taskStatus=taskStatus;
    }

}
