package com.examly.model;

import java.util.Date;

@Entity
@AllArgsConstructor
public class Task 
{
    @Id

    private int taskId ;
    private String taskHolderName;
    private Date taskDate;
    private String taskName;
    private String taskStatus;

    

}
