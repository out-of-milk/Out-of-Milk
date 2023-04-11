package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.Ingredient;
import com.outofmilk.outofmilk.models.User;
import com.outofmilk.outofmilk.repositories.IngredientRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    // just testing getting ingredients
    private final IngredientRepository ingredientDao;

    // just testing getting ingredients
    public UserController(IngredientRepository ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @GetMapping("/user")
    public String showProfileForm(Model model){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("hey");
        if (user == null) {
            return "/login";
        }

        List<Ingredient> ingredients = ingredientDao.findAll();

        model.addAttribute("ingredients", ingredients);
        model.addAttribute("user", new User());

        return "users/profile";
    }
}
