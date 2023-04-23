package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.Ingredient;
import com.outofmilk.outofmilk.models.User;
import com.outofmilk.outofmilk.repositories.UserRepository;
import com.twilio.converter.Promoter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class SmsController {

    @Autowired
    private UserRepository userDao;

    @Value("${twilio.account.sid}")
    private String twilioSid;

    @Value("${twilio.auth.token}")
    private String twilioToken;

    @GetMapping(value = "/user/tgl")
    public String sendSMS(@RequestParam String phoneNumber, Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", user);

        List<Ingredient> sortedItems = new ArrayList<>(user.getGroceryItems());
        Collections.sort(sortedItems, Comparator.comparing(Ingredient::getName));

        String textBody = "";
        for (Ingredient item : sortedItems){
            textBody += item.getName().substring(0, 1).toUpperCase() + item.getName().substring(1) + "\n";
        }

        System.out.println(textBody);

        try {
            Twilio.init(twilioSid, twilioToken);

            Message.creator(new PhoneNumber(phoneNumber),
                            new PhoneNumber("+18339301486"), textBody).create();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/user";

    }
}

