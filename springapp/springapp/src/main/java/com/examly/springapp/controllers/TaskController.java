package com.examly.controllers;


@RestController
@RequestMapping("/tasks")
public class TaskController 
{
    private final TaskService taskService;
    public TaskController(TaskService taskService) 
    {
        this.taskService = taskService;
    }
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) 
    {
        Task savedTask = taskService.createTask(task);
        return ResponseEntity.ok(savedTask);
    }
    @GetMapping("/alltasks")
    public ResponseEntity<List<Task>> alltasks() {
        List<Task> tasks = taskService.alltasks();
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/getTask/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
        Task task = taskService.getTask(taskId);
        return ResponseEntity.ok(task);
    }
    @PutMapping("/changeStatus/{taskId}")
    public ResponseEntity<Task> changeStatus(@PathVariable Long taskId, @RequestBody Task task) {
        Task updatedTask = taskService.changeStatus(taskId, task);
        return ResponseEntity.ok(updatedTask);
    }
    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }
}
    
