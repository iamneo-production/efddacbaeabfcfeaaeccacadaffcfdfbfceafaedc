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
    public String deleteTask(@RequestParam long id) {
        taskService.deleteTask(id);
        return "redirect:/deleteTask/{id}";
    }

    @RequestMapping(value = "/chagngeStatus/{id}", method = RequestMethod.GET)
    public String chagngeStatus(@RequestParam long id, ModelMap model) {
        Task task = taskService.getTaskById(id).get();
        model.put("task", task);
        return "task";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUserName(getLoggedInUserName(model));
        todoService.saveTodo(todo);
        return "redirect:/list-todos";
    }
}

    
