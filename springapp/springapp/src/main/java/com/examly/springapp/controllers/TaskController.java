package com.examly.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;
import com.examly.springapp.service.TaskService;

@RestController
@RequestMapping("/taskproject")
public class TaskController 
{
    @Autowired
    private TaskService taskService;

    @PutMapping("/task/{id}")
    public ResponseEntity<?> addTask(@RequestBody Task taskPara,@PathVariable Long id)
    {
        if(taskService.existById(id))
        {
            Task task=taskService.getTaskById(id).orElseThrow(()->new EntityNotFoundException("Requested Task not found"));
            task.setTaskHolderName(taskPara.getTaskHolderName());
            task.setTaskDate(taskPara.getTaskDate());
            task.setTaskName(taskPara.getTaskName());
            task.setTaskStatus(taskPara.getTaskStatus());

            taskService.saveTask(task);
            return ResponseEntity.ok().body(task);
        }
        else
        {
            HashMap<String,String>message=new HashMap<>();
            message.put("message",id+"task not fund or matched");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        }

}