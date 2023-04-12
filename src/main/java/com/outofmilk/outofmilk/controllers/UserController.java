package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.Ingredient;
import com.outofmilk.outofmilk.models.User;
import com.outofmilk.outofmilk.repositories.IngredientRepository;
import com.outofmilk.outofmilk.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    // just testing getting ingredients
    private final IngredientRepository ingredientDao;
    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    // just testing getting ingredients
    public UserController(IngredientRepository ingredientDao, UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.ingredientDao = ingredientDao;
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/user")
    public String showProfileForm(Model model){

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());

        System.out.println("hey");
        if (user == null) {
            return "/login";
        }

        List<Ingredient> ingredients = ingredientDao.findAll();

        model.addAttribute("ingredients", ingredients);
        model.addAttribute("user", user);

        return "users/profile";
    }

    @PostMapping("/user")
    public String changeUserSettings(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "email") String email
    ){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId()).get();


        user.setUsername(username);
        user.setEmail(email);

        userDao.save(user);
        return "users/login";
    }
}
