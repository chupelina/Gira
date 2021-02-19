package com.example.exampreparation.web;

import com.example.exampreparation.security.CurrentUser;
import com.example.exampreparation.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model){
        if(currentUser.getId()==null){
            return "index";
        }
        if(!model.containsAttribute("allTasks")){
            model.addAttribute("allTasks", taskService.getAllTasks() );
        }
        return "home";
    }
    @PostMapping("/all")
    public String homeConfig(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("allTasks", taskService.getAllTasks());
        return "redirect:/";
    }

}
