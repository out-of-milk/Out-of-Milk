package com.outofmilk.outofmilk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String showProfileForm(){
        return "users/profile";
    }
}
