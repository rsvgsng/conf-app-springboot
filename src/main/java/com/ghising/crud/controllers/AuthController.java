package com.ghising.crud.controllers;


import com.ghising.crud.dto.LoginDTO;
import com.ghising.crud.dto.SignupDto;
import com.ghising.crud.entity.UserEntity;
import com.ghising.crud.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private  final AuthService authService;


    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("login", new LoginDTO());
        return "auth/login";
    }

    @PostMapping("/login")
    public String handleLogin(
            @Valid
            @ModelAttribute ("login") LoginDTO user,
            BindingResult result,
            Model model
    ) {
        if(result.hasErrors()){
            model.addAttribute("error","Please fill in the required fields");
            return "auth/login";
        }
        try{
            authService.login(user.getUsername(),user.getPassword());
            model.addAttribute("success", "Login successful");
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return  "auth/login";
        }
        return "auth/login";
    }


    @PostMapping("/register")
    public  String showRegister (
            @Valid @ModelAttribute("register")SignupDto user,
            BindingResult result,
            Model model
            ) {
        if(result.hasErrors()){
            return  "auth/register";
        }
        try{
            authService.register(user.getName(), user.getUsername(),user.getPassword());
            model.addAttribute("success", "User registered successfully");
        }catch (Exception e){
            model.addAttribute("error", "Username already exists or something went wrong");
            return "auth/register";
        }

        return "auth/register";
    }

    @GetMapping("/register")
    public String handleRegister(Model model) {
        model.addAttribute("register", new SignupDto());
        return "auth/register";
    }

}

