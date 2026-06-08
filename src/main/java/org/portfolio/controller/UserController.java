package org.portfolio.controller;

import jakarta.validation.Valid;
import org.portfolio.models.dto.user.UserRegisterDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/reg")
    public String getRegister(){

        return "register";
    }

    @PostMapping("/reg")
    public String postRegister(@Valid UserRegisterDTO userRegisterDTO, Model model){

        if (!model.containsAttribute("userRegisterDTO")){
            model.addAttribute("userRegisterDTO", UserRegisterDTO.class);
        }

        return "redirect:/";
    }
}
