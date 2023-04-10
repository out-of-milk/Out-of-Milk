package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String showProfileForm(Model model){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", new User());

        return "users/profile";
    }
}
