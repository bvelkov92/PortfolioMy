package org.portfolio.controller;

import jakarta.validation.Valid;
import org.portfolio.models.dto.user.UserLoginDTO;
import org.portfolio.models.dto.user.UserRegisterDTO;
import org.portfolio.service.serviceAnotations.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        if (!model.containsAttribute("userLoginDTO")){
            model.addAttribute("userLoginDTO", new UserLoginDTO());
        }
        return "login";
    }


    @GetMapping("/reg")
    public String getRegister(Model model){
        if (!model.containsAttribute("userRegisterDTO")){
            model.addAttribute("userRegisterDTO", new UserRegisterDTO());
        }
        return "register";
    }

    @PostMapping("/reg")
    public String postRegister(@Valid UserRegisterDTO userRegisterDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);
        }

        userService.registerNewUser(userRegisterDTO);

        return "redirect:/";
    }

    @GetMapping("/resume")
    public String getResume(){
        return "resume";
    }




    @GetMapping("/projects")
    public String getProjects(){
        return "projects";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }
}
