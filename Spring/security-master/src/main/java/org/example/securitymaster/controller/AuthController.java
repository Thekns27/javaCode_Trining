package org.example.securitymaster.controller;

import lombok.RequiredArgsConstructor;
import org.example.securitymaster.security.User;
import org.example.securitymaster.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/register")
    public String processRegisterForm(User user, @RequestParam("roleName")String roles,
                                      BindingResult result){
        if(result.hasErrors()){
            return "register";
        }
        System.out.println(user);
        System.out.println(roles);
        authService.register(user,roles);
        return "redirect:/login";
    }
}
