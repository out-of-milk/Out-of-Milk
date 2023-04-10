package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

    // guest user
    @GetMapping("/")
    public String showFindAllForm(Model model){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", new User());

        return "findAll";
    }

    // logged-in user
    @GetMapping("/showRecipe")
    public String showRecipeForm(Model model){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", new User());

        return "showRecipe";
    }

}
