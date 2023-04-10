package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.User;
import com.outofmilk.outofmilk.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    private UserRepository userDao;

    //    public RegistrationController(UserRepository userDao, PasswordEncoder passwordEncoder){
    public RegistrationController(UserRepository userDao){
        this.userDao = userDao;
//        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }
}
