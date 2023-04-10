package com.outofmilk.outofmilk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

    // guest user
    @GetMapping("/")
    public String showFindAllForm(){
        return "findAll";
    }

    // logged-in user
    @GetMapping("/recipe")
    public String showRecipeForm(){
        return "recipe";
    }

}
