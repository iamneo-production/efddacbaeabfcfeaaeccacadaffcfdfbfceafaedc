package com.examly.springapp.model;

import java.util.Date;

import javax.persistence.Column;
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

    public long setTaskId()
    {
        return taskId;
    }

}
