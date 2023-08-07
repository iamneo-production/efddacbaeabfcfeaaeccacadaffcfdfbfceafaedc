package com.examly.controllers;

import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import com.examly.model.Task;
import com.examly.services.Taskservice;
import com.examly.repository.Taskrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Task")
public class Taskcontroller {
    
    @Autowired
    private Taskservice taskservice;
    private Taskrepository taskRepository;

    @PutMapping("/addTask")
    public ResponseEntity<?> addTask(@RequestBody Task taskPara,@PathVariable Long id)
    {
        if(taskservice.existById(id))
        {
            Task task=taskservice.getTaskById(id).orElseThrow(()->new EntityNotFoundException("Requested Task not found"));
            task.setTaskHolderName(taskPara.getTaskHolderName());
            task.setTaskDate(taskPara.getTaskDate());
            task.setTaskName(taskPara.getTaskName());
            task.setTaskStatus(taskPara.getTaskStatus());
        taskRepository.save(task);
        return ResponseEntity.ok(task); 
    }
    else
        {
            HashMap<String,String>message=new HashMap<>();
            message.put("message",id+"task not fund or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task)
    {
        return taskservice.saveTask(task); 
    }

    @GetMapping("/deleteTask")
        public ResponseEntity<?> deleteTask(@PathVariable Long id)
    {
        if(taskservice.existById(id))
        {
            taskservice.deleteTask(id);
            HashMap<String,String>message=new HashMap<>();
            message.put("message",id + "task removed");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        else
        {
            HashMap<String,String>message=new HashMap<>();
            message.put("message",id+"task not fund or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        }

    @GetMapping("/alltasks")
    public List<Task> alltasks()
    {
        return taskservice.getAllTasks();
    }

    @GetMapping("/getTask")
    public Task getTask(@PathVariable Long id)
    {
        return taskservice.getTaskById(id).orElseThrow(()->new EntityNotFoundException("Task not found with id:" +id)); 
    }
}


