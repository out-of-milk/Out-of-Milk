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
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
public class RecipeController {

    private final UserRepository userDao;
    private final RecipeRepository recipeDao;

    @GetMapping("/")
    public String showFindAllForm(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        List<Recipe> recipes = new ArrayList<>();

        if (authentication.getPrincipal() != "anonymousUser") {
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDao.getReferenceById(loggedInUser.getId());

            System.out.println(user);

//            recipes = recipeDao.selectRecommendedRecipes(user.getCategories().toString());
            System.out.println("***************");
            System.out.println(user.getCategories().toString());
            System.out.println("***************");
            recipes = recipeDao.selectRandomRecipes(Long.valueOf("3"));

        } else {
            recipes = recipeDao.selectRandomRecipes(Long.valueOf("3"));
        }

        model.addAttribute("recipes", recipes);
        recipes.get(0).setShowThis(true);

        System.out.println(recipes);

        return "findAll";

    }

}
