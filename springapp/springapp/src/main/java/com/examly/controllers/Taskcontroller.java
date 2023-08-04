package com.examly.controllers;

import java.util.List;

import com.examly.model.Task;
import com.examly.services.Taskservice;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/Task")
public class Taskcontroller {
    
    @Autowired
    private Taskservice service;

      @GetMapping("/alltasks")
      public String add(Model model) {
          List<Task> listcourse = service.listAll();
          model.addAttribute("listcourse", listcourse);
          model.addAttribute("course", new Task());
          return "addcourse";
      }

      @RequestMapping(value = "/save", method = RequestMethod.POST)
      public String saveCourse(@ModelAttribute("course") Task task) {
          service.save(task);
          return "redirect:/task";
      }

      @RequestMapping("/edit/{id}")
      public ModelAndView showEditCoursePage(@PathVariable(name = "id") int id) {
          ModelAndView mav = new ModelAndView("addcourse");
          Task task = service.get(id);
          mav.addObject("course", task);
          return mav;
          
      }
      @RequestMapping("/delete/{id}")
      public String deleteCoursePage(@PathVariable(name = "id") int id) {
          service.delete(id);
          return "redirect:/task";
      }
}
   