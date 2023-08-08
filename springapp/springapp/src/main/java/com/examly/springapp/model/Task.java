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



}
