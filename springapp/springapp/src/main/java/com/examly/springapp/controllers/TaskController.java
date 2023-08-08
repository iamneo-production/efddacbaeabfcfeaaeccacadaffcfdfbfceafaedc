package com.examly.springapp.controllers;
@Controller
@RequestMapping("/api/v1/tasks")
public class TaskController
{

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
}