package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.User;
import com.outofmilk.outofmilk.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userDao, PasswordEncoder passwordEncoder){
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user, Model model){

        System.out.println(user);

        User userNameCheck = userDao.findByUsername(user.getUsername());
        User userEmailCheck = userDao.findByEmail(user.getEmail());

        if (userNameCheck != null) {
            model.addAttribute("userExists", true);
        }

        if (userEmailCheck != null) {
            model.addAttribute("userEmailExists", true);
        }

        if ((userNameCheck != null) || (userEmailCheck != null)) {
            return "users/sign-up";
        }

        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

}
