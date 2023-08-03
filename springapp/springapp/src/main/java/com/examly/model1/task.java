package com.examly.model1;

import java.util.Date;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class task 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="Id")
    private Long id;
    private String title;
    private String type;
    private Date dueDate;
    private String description;
  
    
}
