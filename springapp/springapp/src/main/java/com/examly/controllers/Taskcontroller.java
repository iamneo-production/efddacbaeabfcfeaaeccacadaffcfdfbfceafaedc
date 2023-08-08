package com.examly.controllers;

import javax.persistence.EntityNotFoundException;
import com.examly.model.Task;
import java.util.HashMap;
import java.util.Optional;

import com.examly.services.Taskservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class Taskcontroller {

    @Autowired
    private Taskservice taskservice;

    @GetMapping("/alltasks")
    public ResponseEntity<?> alltasks(@RequestBody Task taskPara,@PathVariable Long taskId) {
        if(taskservice.existById(taskId))
        {
            Task task=taskservice.getTaskById(taskId).orElseThrow(()->new EntityNotFoundException("Requested Task not found"));
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
            message.put("message",taskId+"task not fund or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task)
    {
        return taskservice.saveTask(task); 
    }

    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskservice.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) 
    {
    return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
}
    
    
}