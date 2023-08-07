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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Task")
public class Taskcontroller {
    
    @Autowired
    private Taskservice taskservice;
    private Taskrepository taskRepository;

    @PostMapping("/saveTask")
    public ResponseEntity<?> saveTask(@RequestBody Task taskPara,@PathVariable Long id)
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

    @GetMapping("/changeStatus/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task task)
    {
        Task updatedTask = taskservice.updateTask(id,task);
        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping("deleteTask/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id)
    {
        taskservice.deleteTask(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/alltasks")
    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    @GetMapping("/getTask/{id}")
    public Task getTaskById(@PathVariable Long id)
    {
        return taskRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Task not found with id:" +id)); 
    }
}


