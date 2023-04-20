package com.outofmilk.outofmilk.controllers;

import com.outofmilk.outofmilk.models.Category;
import com.outofmilk.outofmilk.models.Recipe;
import com.outofmilk.outofmilk.models.RecipePreference;
import com.outofmilk.outofmilk.models.User;
import com.outofmilk.outofmilk.repositories.RecipePreferenceRepository;
import com.outofmilk.outofmilk.repositories.RecipeRepository;
import com.outofmilk.outofmilk.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@AllArgsConstructor
@Controller
public class RecipeController {

    private final UserRepository userDao;
    private final RecipeRepository recipeDao;
    private final RecipePreferenceRepository recipePreferenceDao;


    @GetMapping("/")
    public String showFindAllForm(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        List<Recipe> recipes = new ArrayList<>();
        List<Recipe> finalRecipes = new ArrayList<>();

        if (authentication.getPrincipal() != "anonymousUser") {
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userDao.getReferenceById(loggedInUser.getId());

            List<RecipePreference> recipePreferencesHidden = (List<RecipePreference>) recipePreferenceDao.findHiddenById(user);

            List<String> categoryNames = new ArrayList<>();

            for (Category category : user.getCategories()) {
                categoryNames.add(category.getName());
            }

            if (categoryNames != null && !categoryNames.isEmpty()) {
                recipes = recipeDao.findByStrCategoryIn(categoryNames);

                finalRecipes = new ArrayList<>(recipes);
                for (Recipe recipe : recipes) {
                    for (RecipePreference preference : recipePreferencesHidden) {
                        if (recipe.getIdMeal() == preference.getRecipe().getIdMeal()) {
                            finalRecipes.remove(recipe);
                            break;
                        }
                    }
                }

                Collections.shuffle(finalRecipes);
                while (finalRecipes.size() > 3) {
                    finalRecipes.remove(finalRecipes.size() - 1);
                }
            }

            if (finalRecipes.size() == 0) {
                List<Recipe> randomRecipes = recipeDao.selectRandomRecipes(Long.valueOf("3"));
                finalRecipes.addAll(randomRecipes);
            } else if (finalRecipes.size() == 1) {
                List<Recipe> randomRecipes = recipeDao.selectRandomRecipes(Long.valueOf("2"));
                finalRecipes.addAll(randomRecipes);
            } else if (finalRecipes.size() == 2) {
                List<Recipe> randomRecipes = recipeDao.selectRandomRecipes(Long.valueOf("1"));
                finalRecipes.addAll(randomRecipes);
            }

        } else {
            finalRecipes = recipeDao.selectRandomRecipes(Long.valueOf("3"));
        }

        System.out.println(finalRecipes);

        model.addAttribute("finalRecipes", finalRecipes);
        finalRecipes.get(0).setShowThis(true);

        return "findAll";

    }

}
