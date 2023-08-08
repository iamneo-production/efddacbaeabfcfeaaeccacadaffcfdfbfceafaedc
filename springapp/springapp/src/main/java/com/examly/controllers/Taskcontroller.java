package com.examly.controllers;

import ent
import com.examly.model.Task;
import java.util.HashMap;
import com.examly.services.Taskservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class Taskcontroller {

    @Autowired
    private Taskservice taskservice;

    @PutMapping("/")
    public ResponseEntity<Task> addTask(@RequestBody Task taskPara,@PathVariable Long id) {
        if(taskservice.existById(id))
        {
            Task task=taskservice.getTaskById(id).orElseThrow(()->new EntityNotFoundException("Requested Task not found"));
            task.setTaskId(taskPara.getTaskId());
            task.setTaskHolderName(taskPara.getTaskHolderName());
            task.setTaskDate(taskPara.getTaskDate());
            task.setTaskName(taskPara.getTaskName());
            task.setTaskStatus(taskPara.getTaskStatus());
            taskservice.saveTask(task);
            return ResponseEntity.ok().body(task);
        }
        else
        {
            HashMap<String,String>message=new HashMap<>();
            message.put("message",id+"task not fund or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @PostMapping("/task")
    public Task addTask(@RequestBody Task task)
    {
        return taskservice.saveTask(task); 
    }

    
    
}