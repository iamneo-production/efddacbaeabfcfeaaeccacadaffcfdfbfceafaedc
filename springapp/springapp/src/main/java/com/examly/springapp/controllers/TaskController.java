package com.examly.springapp.controllers;

import org.springframework.stereotype.Controller;

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
        Task task = taskService.getTaskByTaskId(taskId).get();
        model.put("task", task);
        return "task";
    }

}

    
