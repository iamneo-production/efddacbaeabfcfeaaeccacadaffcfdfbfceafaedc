package com.examly.springapp.controllers;

import java.util.List;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;
import com.examly.springapp.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class TaskController {

    private TaskService taskService;

    @GetMapping("/getTask")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @PostMapping("/createTask")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        task.setTaskHolderName("Gowthaman M");
        task.setTaskDate("2021/04/15");
        task.setTaskName("Spring Projects");
        task.setTaskStatus("In Progress");
        taskRepository.save(task);
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

}
