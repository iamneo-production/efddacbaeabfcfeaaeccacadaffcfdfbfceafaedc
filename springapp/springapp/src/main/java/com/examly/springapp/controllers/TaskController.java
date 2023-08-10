package com.examly.springapp.controllers;

import java.util.List;

import com.examly.springapp.service.TaskService;
import com.examly.springapp.model.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/alltasks")
    public List<Task> getTask()
    {
        return taskService.getTasks();
    }

    @PostMapping("/alltasks")
    public Task addTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @GetMapping("/alltasks/{id}")
    public Task  getTaskId(@PathVariable Long taskid){
       return taskService.getTaskId(taskid);
    }

    @DeleteMapping("/admin/deleteAddon/{addOnid}")
    public ResponseEntity<Map<String, Boolean>> deleteAddon(@PathVariable Long addOnid){
        taskService.deleteAddon(addOnid);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
}

    

}
