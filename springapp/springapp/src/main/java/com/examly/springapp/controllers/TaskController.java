package com.examly.springapp.controllers;

import java.util.List;
import com.examly.springapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.service.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private TaskService taskService;

    @GetMapping("/getTask")
    public List<Task> getTask()
    {
        return taskService.getAllTasks();
    }

}
