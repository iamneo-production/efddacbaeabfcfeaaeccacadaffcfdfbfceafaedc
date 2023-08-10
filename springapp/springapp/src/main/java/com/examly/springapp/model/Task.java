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

    @Column(name="task_Id")
    private Integer taskId;

    @Column(name="task_HolderName")
    private String taskHolderName;

    @Column(name="task_Date")
    private String taskDate;

    @Column(name="task_Name")
    private String taskName;

    @Column(name="task_Status")
    private String taskStatus;

    public Task()
    {
    }

    public Task(Integer taskId, String taskHolderName, String taskDate, String taskName,String taskStatus) 
    {
        super();
        this.taskId=taskId;
        this.taskHolderName = taskHolderName;
        this.taskDate = taskDate;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }

    public Integer getTaskId() 
    {
        return taskId;
    }

    public void setTaskId(Integer taskId) 
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


