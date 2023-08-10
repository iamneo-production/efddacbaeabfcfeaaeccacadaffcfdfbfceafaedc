package com.examly.springapp.controllers;

import java.util.*;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/saveTask")
    public List<Task> getTask()
    {
        return taskService.getTasks();
    }

    @PostMapping("/saveTask")
    public ResponseEntity<Task> saveTask(@RequestBody Task task)
    {
    taskRepository.save(task);
    return ResponseEntity.ok(task);
    }

    @GetMapping("/getTask")
    public Optional<Task>  getTaskId(@PathVariable Integer taskid){
       return taskService.getTaskId(taskid);
    }

    @DeleteMapping("/deleteTask")
    public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Integer taskid){
        taskService.deleteTask(taskid);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
}
}
