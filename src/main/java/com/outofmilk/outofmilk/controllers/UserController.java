package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.*;

import com.outofmilk.outofmilk.models.RecipePreference;
import com.outofmilk.outofmilk.models.User;

import com.outofmilk.outofmilk.repositories.*;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Controller
public class UserController {

    private final UserRepository userDao;

    private final RecipeRepository recipeDao;
    private final RecipePreferenceRepository recipePreferenceDao;
    private final CategoryRepository categoryDao;
    private final PasswordEncoder passwordEncoder;
    private final IngredientRepository ingredientDao;


    @GetMapping("/user")
    @Transactional
    public String showProfileForm(Model model) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (loggedInUser == null) {
            return "/login";
        }
        System.out.println("****************");
        System.out.println(loggedInUser);
        System.out.println("****************");

        User user = userDao.getReferenceById(loggedInUser.getId());

        List<RecipePreference> recipePreferencesFavorites = (List<RecipePreference>) recipePreferenceDao.findFavoritesById(user);
        recipePreferencesFavorites.get(0).getRecipe().setShowThis(true);

        List<RecipePreference> recipePreferencesHidden = (List<RecipePreference>) recipePreferenceDao.findHiddenById(user);
        List<Category> categories = categoryDao.findAll();
        List<Ingredient> ingredients = (List<Ingredient>) ingredientDao.findAll();


        model.addAttribute("ingredients", ingredients);
        model.addAttribute("user", user);
        model.addAttribute("recipePreferencesFavorites", recipePreferencesFavorites);
        model.addAttribute("recipePreferencesHidden", recipePreferencesHidden);
        model.addAttribute("categories", categories);

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

        if (user == null) {
            return "/login";
        }

        List<RecipePreference> recipePreferencesFavorites = (List<RecipePreference>) recipePreferenceDao.findFavoritesById(user);
        List<RecipePreference> recipePreferencesHidden = (List<RecipePreference>) recipePreferenceDao.findHiddenById(user);

        model.addAttribute("user", user);
        model.addAttribute("recipePreferencesFavorites", recipePreferencesFavorites);
        model.addAttribute("recipePreferencesHidden", recipePreferencesHidden);

        if (loggedInUser.getId() == user.getId()) {
            recipePreferenceDao.deleteHiddenRecipeById(user.getId(), Long.valueOf(id));
        }

        return "redirect:/user";

    }

    @PostMapping("/user/{id}/uc")
    public String updateFavoriteCategories(@RequestParam("categories") @Nullable List<String> categoryNames) {

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());

        if (user == null) {
            return "/login";
        }

        List<Category> categories = new ArrayList<>();

        if (categoryNames != null) {
            categories = categoryDao.findByNameIn(categoryNames);
        }

        user.setCategories(categories);

        if (loggedInUser.getId() == user.getId()) {
            userDao.save(user);
        }

        return "redirect:/user";

    }

    @GetMapping("/user/addItemPantry")
    public String addItemToPantry(@RequestParam String selectedIngredient, Model model){
        System.out.println(selectedIngredient);
        Ingredient newIngredient = ingredientDao.findByName(selectedIngredient);
        long id = newIngredient.getId();

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());
        if (user == null) {
            return "redirect:/login";
        }
        System.out.println("help!!!");
//        grab ingredient by id
        Ingredient ingredient =  ingredientDao.findById(id);
        System.out.println(ingredient);
        user.getPantryItems().add(ingredient);

        model.addAttribute("user", user);
        model.addAttribute("ingredients", ingredientDao.findAll());
        if (loggedInUser.getId() == user.getId()) {
            userDao.save(user);
        }
        return "redirect:/user";
    }
    @GetMapping("/user/addItemGrocery")
    public String addItemToGrocery(@RequestParam String selectedIngredient, Model model){
        System.out.println(selectedIngredient);
        Ingredient newIngredient = ingredientDao.findByName(selectedIngredient);
        long id = newIngredient.getId();

        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());
        if (user == null) {
            return "redirect:/login";
        }
        System.out.println("help!!!");
//        grab ingredient by id
        Ingredient ingredient =  ingredientDao.findById(id);
        System.out.println(ingredient);
        user.getGroceryItems().add(ingredient);

        model.addAttribute("user", user);
        model.addAttribute("ingredients", ingredientDao.findAll());
        if (loggedInUser.getId() == user.getId()) {
            userDao.save(user);
        }
        return "redirect:/user";
    }

    @GetMapping("/user/{id}/afr")
    public String addFavRecipe(@PathVariable long id, Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());

        List<RecipePreference> allRecipePreferences = recipePreferenceDao.findAll();
        List<RecipePreference> recipePreferencesFavorites = recipePreferenceDao.findFavoritesById(user);
        List<RecipePreference> recipePreferencesHidden = recipePreferenceDao.findHiddenById(user);
        Recipe viewedRecipe = recipeDao.findByIdMeal(id);



        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", user);
        model.addAttribute("recipePreferencesFavorites", recipePreferencesFavorites);
        model.addAttribute("recipePreferencesHidden", recipePreferencesHidden);

        for (RecipePreference recipePreference : recipePreferencesFavorites) {
            if(recipePreference.getRecipe().getId() == viewedRecipe.getId()){
                allRecipePreferences.remove(recipePreference);
            }
        }

        RecipePreference newFavorite = new RecipePreference();
        newFavorite.setUser(user);
        newFavorite.setRecipe(viewedRecipe);
        newFavorite.setFavorite(true);
        newFavorite.setHidden(false);

        allRecipePreferences.add(newFavorite);

        user.setRecipePreferences(allRecipePreferences);
        userDao.save(user);

        return "redirect:/user";
    }

    @GetMapping("/user/{id}/ahr")
    public String addHiddenRecipe(@PathVariable long id, Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());

        List<RecipePreference> allRecipePreferences = recipePreferenceDao.findAll();
        List<RecipePreference> recipePreferencesFavorites = recipePreferenceDao.findFavoritesById(user);
        List<RecipePreference> recipePreferencesHidden = recipePreferenceDao.findHiddenById(user);
        Recipe viewedRecipe = recipeDao.findByIdMeal(id);



        if (user == null) {
            return "/login";
        }

        model.addAttribute("user", user);
        model.addAttribute("recipePreferencesFavorites", recipePreferencesFavorites);
        model.addAttribute("recipePreferencesHidden", recipePreferencesHidden);

        for (RecipePreference recipePreference : recipePreferencesHidden) {
            if(recipePreference.getRecipe().getId() == viewedRecipe.getId()){
                allRecipePreferences.remove(recipePreference);
            }
        }

        RecipePreference newHidden = new RecipePreference();
        newHidden.setUser(user);
        newHidden.setRecipe(viewedRecipe);
        newHidden.setFavorite(false);
        newHidden.setHidden(true);

        allRecipePreferences.add(newHidden);

        user.setRecipePreferences(allRecipePreferences);
        userDao.save(user);

        return "redirect:/user";
    }

}
