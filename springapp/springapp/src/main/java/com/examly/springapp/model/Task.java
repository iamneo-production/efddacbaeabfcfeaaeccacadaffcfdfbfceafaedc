package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="tasks")
public class Task 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long taskId;
    private String taskHolderName;
    private String taskDate;
    private String taskName;
    private String taskStatus;

    public Task()
    {
    }

    public Task(Long taskId, String taskHolderName, String taskDate, String taskName,String taskStatus) 
    {
        super();
        this.taskId=taskId;
        this.taskHolderName = taskHolderName;
        this.taskDate = taskDate;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public void setTaskId(Long taskId) 
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

    public String getTaskDate() 
    {
        return taskDate;
    }

    public void setTaskDate(String taskDate) 
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


    @Override
    public String toString() {
        return "{" +
            " taskId='" + getTaskId() + "'" +
            ", taskHolderName='" + getTaskHolderName() + "'" +
            ", taskDate='" + getTaskDate() + "'" +
            ", taskName='" + getTaskName() + "'" +
            ", taskStatus='" + getTaskStatus() + "'" +
            "}";
    }

}


