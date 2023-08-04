package com.examly.model;

import java.util.Date;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name ="task")
public class Task 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    
    @Column(name ="task_HolderName")
    private String taskHolderName;

    @Column(name ="task_Date")
    private Date taskDate;

    @Column(name ="task_Name")
    private String taskName;

    @Column(name ="task_Status")
    private String taskStatus;
    
    Task(String taskHolderName, Date taskDate, String taskName, String taskStatus) {
        this.taskHolderName = taskHolderName;
        this.taskDate = taskDate;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }
    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    public String getTaskHolderName() {
        return taskHolderName;
    }
    public void setTaskHolderName(String taskHolderName) {
        this.taskHolderName = taskHolderName;
    }
    public Date getTaskDate() {
        return taskDate;
    }
    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    @Override
    public String toString() {
        return "task [taskId=" + taskId + ", taskHolderName=" + taskHolderName + ", taskDate=" + taskDate
                + ", taskName=" + taskName + ", taskStatus=" + taskStatus + "]";
    }
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }   
}
