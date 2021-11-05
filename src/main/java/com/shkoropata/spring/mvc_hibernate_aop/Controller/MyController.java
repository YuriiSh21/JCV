package com.shkoropata.spring.mvc_hibernate_aop.Controller;

import com.shkoropata.spring.mvc_hibernate_aop.entity.Task;
import com.shkoropata.spring.mvc_hibernate_aop.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public String showAllTasks(Model model) {

        List<Task> allTasks = taskService.getAllTasks();
        model.addAttribute("allTas", allTasks);

        return "all-tasks";
    }

    @RequestMapping("/addNewTask")
    public String addNewTask(Model model) {

        Task task = new Task();
        model.addAttribute("task", task);

        return "task-details";
    }

    @RequestMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task) {

        taskService.saveTask(task);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateTask(@RequestParam("tasId") int id, Model model) {

        Task task = taskService.getTask(id);
        model.addAttribute("task", task);

        return "task-details";
    }

    @RequestMapping("/deleteTask")
    public String deleteTask(@RequestParam("tasId") int id) {

        taskService.deleteTask(id);

        return "redirect:/";
    }
}
