package com.examly.controllers;

public class TaskController {

    Task task = new Task();
    task.setTitle("Learn Spring Boot");
    task.setDescription("This task is to learn Spring Boot");
    task.setCompleted(false);
    TaskController controller = new TaskController();
    controller.createTask(task);
    
}
