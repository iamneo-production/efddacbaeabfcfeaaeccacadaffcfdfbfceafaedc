package com.examly.services;

import com.examly.model.Task;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Taskservice{

    public Task saveTask(Task task) {
        // TODO: save task to database
        return task;
    }
    public List<Task> getTasks() {
        // TODO: get tasks from database
        return null;
}
}