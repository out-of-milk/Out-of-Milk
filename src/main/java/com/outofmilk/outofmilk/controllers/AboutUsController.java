package com.outofmilk.outofmilk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {

    @GetMapping("/AboutUs")
    public String showAboutForm(){
        return "users/AboutUs";
    }

}
