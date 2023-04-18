package com.outofmilk.outofmilk.controllers;

import com.google.gson.*;
import com.outofmilk.outofmilk.models.Category;
import com.outofmilk.outofmilk.models.Recipe;
import com.outofmilk.outofmilk.models.User;
import com.outofmilk.outofmilk.repositories.RecipeRepository;
import com.outofmilk.outofmilk.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@AllArgsConstructor
@Controller
public class RecipeController {

    private final UserRepository userDao;
    private final RecipeRepository recipeDao;

    @GetMapping("/")
    public String showFindAllForm(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication.getPrincipal() != "anonymousUser") {
            System.out.println("**************");
            System.out.println("Logged in user");
            System.out.println("**************");
        } else {

            List<Recipe> recipes = recipeDao.selectRandomRecipes(Long.valueOf("3"));
            model.addAttribute("recipes", recipes);


            System.out.println(recipes);

            System.out.println("******************");
            System.out.println("Not logged in user");
            System.out.println("******************");
        }

        return "findAll";

    }

}
