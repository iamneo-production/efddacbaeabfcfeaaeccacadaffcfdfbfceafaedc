package com.examly.springapp.controllers;

import java.util.List;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Task  getTaskId(@PathVariable Integer taskid){
       return taskService.getTaskId(taskid);
    }

    @DeleteMapping("/admin/deleteAddon/{addOnid}")
    public ResponseEntity<Map<String, Boolean>> deleteTask(@PathVariable Integer taskid){
        taskService.deleteTask(taskid);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
}
}
