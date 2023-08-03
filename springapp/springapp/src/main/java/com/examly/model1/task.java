package com.examly.model1;

import java.util.Date;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class task 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="Id")
    private Long taskId;
    private String taskHolderName;
    private Date taskDate;
    private String taskName;
    private String taskStatus;
    
    public task(Long taskId, String taskHolderName, Date taskDate, String taskName, String taskStatus) {
        this.taskId = taskId;
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
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
  
    
}
