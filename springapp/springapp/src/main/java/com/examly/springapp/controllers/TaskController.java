package com.examly.springapp.controllers;

import java.util.*;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping

public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/saveTask")
    public Task addtask(@RequestBody Task task){
        taskService.save(task);
        return task;
    }

    @GetMapping("/alltasks")
    public List<Task> getTask()
    {
        return taskService.getTask();
    }


    @GetMapping("/getTask/{taskId}")
    public Optional<Task> getTaskId(@PathVariable Long taskId)
    {
        return taskService.getTaskId(taskId);
    }

    @GetMapping("/deleteTask/{taskid}")
    public void deleteTask(@PathVariable Long taskid){
        taskService.deleteTask(taskid);
    }

    @PutMapping("/admin/editAddon/{addOnid}")
    public ResponseEntity<Task> changeStatus(@PathVariable Long taskid,@RequestBody Task task){
        Task tasks = taskService.getTaskId(taskid); 
        tasks.setTaskHolderName(task.getTaskHolderName());
        taskid.setTaskDate(task.getTaskDate());
        taskid.setaddonDescription(task.getTaskName());

        taskService.editAddon(taskid);
        return ResponseEntity.ok(taskid);
    }

}
