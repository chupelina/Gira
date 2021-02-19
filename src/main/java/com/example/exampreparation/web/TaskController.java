package com.example.exampreparation.web;

import com.example.exampreparation.models.serveces.TaskAddingModel;
import com.example.exampreparation.security.CurrentUser;
import com.example.exampreparation.services.ClassificationService;
import com.example.exampreparation.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final ClassificationService classificationService;
    private final TaskService taskService;
    private final CurrentUser currentUser;

    public TaskController(ClassificationService classificationService, TaskService taskService, CurrentUser currentUser) {
        this.classificationService = classificationService;
        this.taskService = taskService;
        this.currentUser = currentUser;
    }

    @GetMapping("/add")

        public String addTask(Model model){
        if(currentUser.getId()==null){
            return "index";
        }
        if(!model.containsAttribute("taskAddingModel")){
            model.addAttribute("taskAddingModel", new TaskAddingModel());
            model.addAttribute("classifications", classificationService.getAllClassifications());
        }
        return "add-task";
    }
    @PostMapping("/add")
    public String taskConfirm(@Valid TaskAddingModel taskAddingModel, BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("taskAddingModel", taskAddingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddingModel"
            , bindingResult);
            redirectAttributes.addFlashAttribute("classifications", classificationService.getAllClassifications());
            return "redirect:add";
        }
        taskService.addTask(taskAddingModel, currentUser.getId());
        return "redirect:/";

    }
    @GetMapping("/change/{id}")

    private String change(@PathVariable Long id){
        if(currentUser.getId()==null){
            return "index";
        }
        taskService.changeProgress(id);
        return  "redirect:/";
    }


}
