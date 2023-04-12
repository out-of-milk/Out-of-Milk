package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.User;
import com.outofmilk.outofmilk.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class UserController {
    private final UserRepository userDao;

    @GetMapping("/user")
    public String showProfileForm(Model model){

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.findById(loggedInUser.getId()).get();

        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", user);

        System.out.println("*********************");
        System.out.println(user);
        System.out.println("*********************");

        return "users/profile";
    }
}
