package com.example.exampreparation.web;

import com.example.exampreparation.models.serveces.UserLoginModel;
import com.example.exampreparation.models.serveces.UserRegisterServiceModel;
import com.example.exampreparation.models.serveces.UserServiceModel;
import com.example.exampreparation.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    private String registerUser(Model model) {
        if (!model.containsAttribute("userRegisterServiceModel")) {
            model.addAttribute("userRegisterServiceModel", new UserRegisterServiceModel());
            model.addAttribute("matchingPasswords", true);
        }
        return "register";
    }

    @PostMapping("/register")
    private String confirmRegister(@Valid UserRegisterServiceModel userModel,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterServiceModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterServiceModel",
                    bindingResult);
            return "redirect:register";
        }
        if (!userModel.getConfirmPassword().equals(userModel.getPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterServiceModel", userModel);
            redirectAttributes.addFlashAttribute("matchingPasswords", true);
            return "redirect:register";
        }
        userService.registerUser(modelMapper.map(userModel, UserServiceModel.class));
        return "redirect:login";
    }


    @GetMapping("/login")
    private String loginUser(Model model) {
        if (!model.containsAttribute("userLoginModel")) {
            model.addAttribute("userLoginModel", new UserLoginModel());
            model.addAttribute("found", true);
        }
        return "login";
    }

    @PostMapping("/login")
    private String confirmLogin(@Valid UserLoginModel userLoginModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginModel",
                    bindingResult);
            redirectAttributes.addFlashAttribute("found", true);
            return "redirect:login";
        }
        UserServiceModel userServiceModel =
                userService.findCurrentUser(modelMapper.map(userLoginModel, UserServiceModel.class));

        if (userServiceModel != null) {
            userService.loginUser(userServiceModel);
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("userLoginModel", userLoginModel);
        redirectAttributes.addFlashAttribute("found", false);
        return "redirect:login";
    }


    @GetMapping("/logout")
    private String logoutUser() {
        userService.logout();
        return "redirect:/";
    }


}
