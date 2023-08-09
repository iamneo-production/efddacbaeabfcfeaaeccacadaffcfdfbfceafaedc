package com.examly.springapp.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.examly.springapp.model.Task;
import com.examly.springapp.service.TaskService;

@Controller
public class TaskController 
{
    @Autowired
    private TaskService taskService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/addtask", method = RequestMethod.GET)
    public String addtask(ModelMap model) {
        model.addAttribute("task", new Task());
        return "task";
    }

    @RequestMapping(value = "/deleteTask/{id}", method = RequestMethod.GET)
    public String deleteTask(@RequestParam long taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/deleteTask/{id}";
    }

    @RequestMapping(value = "/chagngeStatus/{id}", method = RequestMethod.GET)
    public String chagngeStatus(@RequestParam long taskId, ModelMap model) {
        Task task = taskService.getTaskById(taskId).get();
        model.put("task", task);
        return "task";
    }

}

    
