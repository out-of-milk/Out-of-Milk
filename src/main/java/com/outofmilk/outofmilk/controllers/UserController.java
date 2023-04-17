package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.Ingredient;
import com.outofmilk.outofmilk.models.RecipePreference;
import com.outofmilk.outofmilk.models.User;

import com.outofmilk.outofmilk.repositories.RecipePreferenceRepository;
import com.outofmilk.outofmilk.repositories.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class UserController {

    private final UserRepository userDao;
    private final RecipePreferenceRepository recipePreferenceDao;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/user")
    public String showProfileForm(Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());
        List<RecipePreference> recipePreferencesFavorites = (List<RecipePreference>) recipePreferenceDao.findFavoritesById(user);
        List<RecipePreference> recipePreferencesHidden = (List<RecipePreference>) recipePreferenceDao.findHiddenById(user);

        System.out.println("********* Favorites ************");
        System.out.println(recipePreferencesFavorites);
        System.out.println("********* Hidden ************");
        System.out.println(recipePreferencesHidden);
        System.out.println("********* End ************");

        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", user);
        model.addAttribute("recipePreferencesFavorites", recipePreferencesFavorites);
        model.addAttribute("recipePreferencesHidden", recipePreferencesHidden);

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

        if(password.equals(confirmPass) && !password.equals("")){
            String hash = passwordEncoder.encode(password);
            user.setPassword(hash);
        }

        userDao.save(user);
        return "users/login";
    }

    @GetMapping("/user/{id}/dpi")
    @Transactional
    public String deletePantryIngredientItemFromList(@PathVariable long id, Model model){

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());

        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", user);

        if (loggedInUser.getId() == user.getId()) {
            userDao.deletePantryItemIngredientById(user.getId(), Long.valueOf(id));
        }

        return "redirect:/user";

    }

    @GetMapping("/user/{id}/dgl")
    @Transactional
    public String deleteGroceryListIngredientFromList(@PathVariable long id, Model model){

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());

        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", user);

        if (loggedInUser.getId() == user.getId()) {
            userDao.deleteGroceryListIngredientById(user.getId(), Long.valueOf(id));
        }

        return "redirect:/user";

    }

    @GetMapping("/user/{id}/dhr")
    @Transactional
    public String deleteHiddenRecipeFromList(@PathVariable long id, Model model){

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());
        List<RecipePreference> recipePreferencesFavorites = (List<RecipePreference>) recipePreferenceDao.findFavoritesById(user);
        List<RecipePreference> recipePreferencesHidden = (List<RecipePreference>) recipePreferenceDao.findHiddenById(user);

        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", user);
        model.addAttribute("recipePreferencesFavorites", recipePreferencesFavorites);
        model.addAttribute("recipePreferencesHidden", recipePreferencesHidden);

        if (loggedInUser.getId() == user.getId()) {
            System.out.println("*******************************");
            System.out.println(Long.valueOf(id));
            System.out.println(user.getId());
            System.out.println("*******************************");
            recipePreferenceDao.deleteHiddenRecipeById(user.getId(), Long.valueOf(id));
        }

        return "redirect:/user";

    }

    @PostMapping("/user/{id}/addItemPantry")
    public String addItemToPantry(@PathVariable long id, Model model){

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());
        List<Ingredient> pantryItems = (List<Ingredient>)
//        Ingredient ingredient = ingredient.getById(id);
//        user.getPantryItems().add(ingredient);


//        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = userDao.getReferenceById(loggedInUser.getId());
//        List<RecipePreference> recipePreferencesFavorites = (List<RecipePreference>) recipePreferenceDao.findFavoritesById(user);
//        List<RecipePreference> recipePreferencesHidden = (List<RecipePreference>) recipePreferenceDao.findHiddenById(user);


        if (user == null) {
            return "/login";
        }


        return "redirect:/user";
    }
//    @PostMapping("/tasks/{id}/transfer")
//    public String transferTaskToDepartment(@PathVariable long id, @RequestParam(name="department") long deptId) {
//        Department department = departmentDao.getById(deptId);
//        Task task = taskDao.getById(id);
//        department.getTasks().add(task);
//        task.setDepartment(department);
//        taskDao.save(task);
//        return "redirect:/tasks/" + id;
//    }

}
