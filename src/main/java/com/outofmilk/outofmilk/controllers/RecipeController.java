package com.outofmilk.outofmilk.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RecipeController {

    // guest user
    @GetMapping("/")
    public String showFindAllForm(){
        return "findAll";
    }

//     logged-in user
//    @GetMapping("/recipe/{id}")
//    public String showRecipeForm(){
//        return "showRecipe";
//    }



}
