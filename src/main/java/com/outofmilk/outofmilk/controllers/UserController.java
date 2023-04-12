package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.User;

import com.outofmilk.outofmilk.repositories.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
public class UserController {

    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/user")
    public String showProfileForm(Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());

        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", user);

        return "users/profile";
    }

    @PostMapping("/user")
    public String changeUserSettings(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "confirmPassword") String confirmPass
    ) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId()).get();

        user.setUsername(username);
        user.setEmail(email);

        if(password.equals(confirmPass)){
            String hash = passwordEncoder.encode(password);
            user.setPassword(hash);
        }

        userDao.save(user);
        return "users/login";
    }

    @GetMapping("/user/{id}/dpi")
    @Transactional
    public String deletePantryItemFromList(@PathVariable long id, Model model){

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());

        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", user);

        if (loggedInUser.getId() == user.getId()) {
            userDao.deleteIngredientById(user.getId(), Long.valueOf(id));
        }

        return "redirect:/user";

    }


}
