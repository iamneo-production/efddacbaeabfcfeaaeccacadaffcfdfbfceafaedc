package com.examly.model;

import java.util.Date;

@Entity
public class Task 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long taskId ;
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

    public Long gettaskId()
    {
        return taskId;
    }

    public void settaskId(Long taskId)
    {
        this.taskId=taskId;
    }

    public String gettaskHolderName()
    {
        return taskHolderName;
    }

    public void settaskHolderName(String taskHolderName)
    {
        this.taskHolderName=taskHolderName;
    }

    public String gettaskDate()
    {
        return taskDate;
    }

    public void settaskDate(Date taskDate)
    {
        this.taskDate=taskDate;
    }

    public String gettaskName()
    {
        return taskName;
    }

    public void settaskName(String taskName)
    {
        this.taskName=taskName;
    }

    public String gettaskStatus()
    {
        return taskStatus;
    }

    public void settaskStatus(String taskStatus)
    {
        this.taskStatus=taskStatus;
    }
}
