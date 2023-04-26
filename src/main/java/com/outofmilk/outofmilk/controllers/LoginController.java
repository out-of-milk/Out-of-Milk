package com.outofmilk.outofmilk.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(){
        return "users/login";
    }

    @GetMapping("/login/{id}")
    public String showLoginFormRecipe(@PathVariable long id, Model model, HttpSession session){
        session.setAttribute("recipeId", id);
        return "users/login";
    }


}
