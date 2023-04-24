package com.outofmilk.outofmilk.controllers;

import com.google.gson.*;
import com.outofmilk.outofmilk.models.Ingredient;
import com.outofmilk.outofmilk.models.Recipe;
import com.outofmilk.outofmilk.models.User;
import com.outofmilk.outofmilk.repositories.IngredientRepository;
import com.outofmilk.outofmilk.repositories.RecipeRepository;
import com.outofmilk.outofmilk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class RestController {

    @Value("${mealdb.api.key}")
    private String apiKey;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private IngredientRepository ingredientRepository;

    private final List<Ingredient> ingredients = new ArrayList<>();

    @GetMapping("/recipe/{id}")
    public String callExternalApi(@PathVariable int id, Model model) {
        String jsonResponse = null;

        try {
            System.out.println(apiKey);
            URL url = new URL("https://www.themealdb.com/api/json/v2/1/lookup.php?i=" + id);
//            URL url = new URL("https://www.themealdb.com/api/json/v2/" + apiKey + "/lookup.php?i=" + id);
//            URL url = new URL("https://www.themealdb.com/api/json/v2/" + apiKey + "/lookup.php?i=52814");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "text/plain");
            connection.setRequestMethod("GET");
            connection.getResponseCode();
            jsonResponse = new String(connection.getInputStream().readAllBytes());
            System.out.println("HTTP response code is " + connection.getResponseCode());
            System.out.println(jsonResponse);

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
            System.out.println(jsonObject);
            JsonArray mealsArray = JsonParser.parseString(jsonResponse).getAsJsonObject().getAsJsonArray("meals");
            System.out.println(mealsArray);
            for (JsonElement mealElement : mealsArray) {
                JsonObject mealObject = mealElement.getAsJsonObject();
                String idMeal = mealObject.get("idMeal").getAsString();
                String strMeal = mealObject.get("strMeal").getAsString();
                String strCategory = mealObject.get("strCategory").getAsString();
                String strInstructions = mealObject.get("strInstructions").getAsString();
                String strMealThumb = mealObject.get("strMealThumb").getAsString();

                String strYoutube = "";
                if (!mealObject.get("strYoutube").isJsonNull()) {
                    strYoutube = mealObject.get("strYoutube").getAsString();
                }

                String strIngredient1 = "";
                Ingredient ingredient1 = null;
                if (!mealObject.get("strIngredient1").isJsonNull()) {
                    strIngredient1 = mealObject.get("strIngredient1").getAsString();
                    ingredient1 = ingredientRepository.findByName(strIngredient1.toLowerCase());
                    ingredients.add(ingredient1);
                }

                String strIngredient2 = "";
                Ingredient ingredient2 = null;
                if (!mealObject.get("strIngredient2").isJsonNull()) {
                    strIngredient2 = mealObject.get("strIngredient2").getAsString();
                    ingredient2 = ingredientRepository.findByName(strIngredient2.toLowerCase());
                    ingredients.add(ingredient2);
                }

                String strIngredient3 = "";
                Ingredient ingredient3 = null;
                if (!mealObject.get("strIngredient3").isJsonNull()) {
                    strIngredient3 = mealObject.get("strIngredient3").getAsString();
                    ingredient3 = ingredientRepository.findByName(strIngredient3.toLowerCase());
                    ingredients.add(ingredient3);
                }

                String strIngredient4 = "";
                Ingredient ingredient4 = null;
                if (!mealObject.get("strIngredient4").isJsonNull()) {
                    strIngredient4 = mealObject.get("strIngredient4").getAsString();
                    ingredient4 = ingredientRepository.findByName(strIngredient4.toLowerCase());
                    ingredients.add(ingredient4);
                }

                String strIngredient5 = "";
                Ingredient ingredient5 = null;
                if (!mealObject.get("strIngredient5").isJsonNull()) {
                    strIngredient5 = mealObject.get("strIngredient5").getAsString();
                    ingredient5 = ingredientRepository.findByName(strIngredient5.toLowerCase());
                    ingredients.add(ingredient5);
                }

                String strIngredient6 = "";
                Ingredient ingredient6 = null;
                if (!mealObject.get("strIngredient6").isJsonNull()) {
                    strIngredient6 = mealObject.get("strIngredient6").getAsString();
                    ingredient6 = ingredientRepository.findByName(strIngredient6.toLowerCase());
                    ingredients.add(ingredient6);
                }
                String strIngredient7 = "";
                Ingredient ingredient7 = null;
                if (!mealObject.get("strIngredient7").isJsonNull()) {
                    strIngredient7 = mealObject.get("strIngredient7").getAsString();
                    ingredient7 = ingredientRepository.findByName(strIngredient7.toLowerCase());
                    ingredients.add(ingredient7);
                }
                String strIngredient8 = "";
                Ingredient ingredient8 = null;
                if (!mealObject.get("strIngredient8").isJsonNull()) {
                    strIngredient8 = mealObject.get("strIngredient8").getAsString();
                    ingredient8 = ingredientRepository.findByName(strIngredient8.toLowerCase());
                    ingredients.add(ingredient8);
                }
                String strIngredient9 = "";
                Ingredient ingredient9 = null;
                if (!mealObject.get("strIngredient1").isJsonNull()) {
                    strIngredient9 = mealObject.get("strIngredient9").getAsString();
                    ingredient9 = ingredientRepository.findByName(strIngredient9.toLowerCase());
                    ingredients.add(ingredient9);
                }
                String strIngredient10 = "";
                Ingredient ingredient10 = null;
                if (!mealObject.get("strIngredient10").isJsonNull()) {
                    strIngredient10 = mealObject.get("strIngredient10").getAsString();
                    ingredient10 = ingredientRepository.findByName(strIngredient10.toLowerCase());
                    ingredients.add(ingredient10);
                }
                String strIngredient11 = "";
                Ingredient ingredient11 = null;
                if (!mealObject.get("strIngredient11").isJsonNull()) {
                    strIngredient11 = mealObject.get("strIngredient11").getAsString();
                    ingredient11 = ingredientRepository.findByName(strIngredient11.toLowerCase());
                    ingredients.add(ingredient11);
                }
                String strIngredient12 = "";
                Ingredient ingredient12 = null;
                if (!mealObject.get("strIngredient12").isJsonNull()) {
                    strIngredient12 = mealObject.get("strIngredient12").getAsString();
                    ingredient12 = ingredientRepository.findByName(strIngredient12.toLowerCase());
                    ingredients.add(ingredient12);
                }
                String strIngredient13 = "";
                Ingredient ingredient13 = null;
                if (!mealObject.get("strIngredient13").isJsonNull()) {
                    strIngredient13 = mealObject.get("strIngredient13").getAsString();
                    ingredient13 = ingredientRepository.findByName(strIngredient13.toLowerCase());
                    ingredients.add(ingredient13);
                }
                String strIngredient14 = "";
                Ingredient ingredient14 = null;
                if (!mealObject.get("strIngredient14").isJsonNull()) {
                    strIngredient14 = mealObject.get("strIngredient14").getAsString();
                    ingredient14 = ingredientRepository.findByName(strIngredient14.toLowerCase());
                    ingredients.add(ingredient14);
                }
                String strIngredient15 = "";
                Ingredient ingredient15 = null;
                if (!mealObject.get("strIngredient15").isJsonNull()) {
                    strIngredient15 = mealObject.get("strIngredient15").getAsString();
                    ingredient15 = ingredientRepository.findByName(strIngredient15.toLowerCase());
                    ingredients.add(ingredient15);
                }
                String strIngredient16 = "";
                Ingredient ingredient16 = null;
                if (!mealObject.get("strIngredient16").isJsonNull()) {
                    strIngredient16 = mealObject.get("strIngredient16").getAsString();
                    ingredient16 = ingredientRepository.findByName(strIngredient16.toLowerCase());
                    ingredients.add(ingredient16);
                }
                String strIngredient17 = "";
                Ingredient ingredient17 = null;
                if (!mealObject.get("strIngredient17").isJsonNull()) {
                    strIngredient17 = mealObject.get("strIngredient17").getAsString();
                    ingredient17 = ingredientRepository.findByName(strIngredient17.toLowerCase());
                    ingredients.add(ingredient17);
                }
                String strIngredient18 = "";
                Ingredient ingredient18 = null;
                if (!mealObject.get("strIngredient18").isJsonNull()) {
                    strIngredient18 = mealObject.get("strIngredient18").getAsString();
                    ingredient18 = ingredientRepository.findByName(strIngredient18.toLowerCase());
                    ingredients.add(ingredient18);
                }
                String strIngredient19 = "";
                Ingredient ingredient19 = null;
                if (!mealObject.get("strIngredient19").isJsonNull()) {
                    strIngredient19 = mealObject.get("strIngredient19").getAsString();
                    ingredient19 = ingredientRepository.findByName(strIngredient19.toLowerCase());
                    ingredients.add(ingredient19);
                }
                String strIngredient20 = "";
                Ingredient ingredient20 = null;
                if (!mealObject.get("strIngredient20").isJsonNull()) {
                    strIngredient20 = mealObject.get("strIngredient20").getAsString();
                    ingredient20 = ingredientRepository.findByName(strIngredient20.toLowerCase());
                    ingredients.add(ingredient20);
                }

                ingredients.removeAll(Arrays.asList("", null));

                String strMeasure1 = "";
                if (!mealObject.get("strMeasure1").isJsonNull()) {
                    strMeasure1 = mealObject.get("strMeasure1").getAsString();
                }
                String strMeasure2 = "";
                if (!mealObject.get("strMeasure2").isJsonNull()) {
                    strMeasure2 = mealObject.get("strMeasure2").getAsString();
                }
                String strMeasure3 = "";
                if (!mealObject.get("strMeasure3").isJsonNull()) {
                    strMeasure3 = mealObject.get("strMeasure3").getAsString();
                }
                String strMeasure4 = "";
                if (!mealObject.get("strMeasure4").isJsonNull()) {
                    strMeasure4 = mealObject.get("strMeasure4").getAsString();
                }
                String strMeasure5 = "";
                if (!mealObject.get("strMeasure5").isJsonNull()) {
                    strMeasure5 = mealObject.get("strMeasure5").getAsString();
                }
                String strMeasure6 = "";
                if (!mealObject.get("strMeasure6").isJsonNull()) {
                    strMeasure6 = mealObject.get("strMeasure6").getAsString();
                }
                String strMeasure7 = "";
                if (!mealObject.get("strMeasure7").isJsonNull()) {
                    strMeasure7 = mealObject.get("strMeasure7").getAsString();
                }
                String strMeasure8 = "";
                if (!mealObject.get("strMeasure8").isJsonNull()) {
                    strMeasure8 = mealObject.get("strMeasure8").getAsString();
                }
                String strMeasure9 = "";
                if (!mealObject.get("strMeasure9").isJsonNull()) {
                    strMeasure9 = mealObject.get("strMeasure9").getAsString();
                }
                String strMeasure10 = "";
                if (!mealObject.get("strMeasure10").isJsonNull()) {
                    strMeasure10 = mealObject.get("strMeasure10").getAsString();
                }
                String strMeasure11 = "";
                if (!mealObject.get("strMeasure11").isJsonNull()) {
                    strMeasure11 = mealObject.get("strMeasure11").getAsString();
                }
                String strMeasure12 = "";
                if (!mealObject.get("strMeasure12").isJsonNull()) {
                    strMeasure12 = mealObject.get("strMeasure12").getAsString();
                }
                String strMeasure13 = "";
                if (!mealObject.get("strMeasure13").isJsonNull()) {
                    strMeasure13 = mealObject.get("strMeasure13").getAsString();
                }
                String strMeasure14 = "";
                if (!mealObject.get("strMeasure14").isJsonNull()) {
                    strMeasure14 = mealObject.get("strMeasure14").getAsString();
                }
                String strMeasure15 = "";
                if (!mealObject.get("strMeasure15").isJsonNull()) {
                    strMeasure15 = mealObject.get("strMeasure15").getAsString();
                }
                String strMeasure16 = "";
                if (!mealObject.get("strMeasure16").isJsonNull()) {
                    strMeasure16 = mealObject.get("strMeasure16").getAsString();
                }
                String strMeasure17 = "";
                if (!mealObject.get("strMeasure17").isJsonNull()) {
                    strMeasure17 = mealObject.get("strMeasure17").getAsString();
                }
                String strMeasure18 = "";
                if (!mealObject.get("strMeasure18").isJsonNull()) {
                    strMeasure18 = mealObject.get("strMeasure18").getAsString();
                }
                String strMeasure19 = "";
                if (!mealObject.get("strMeasure19").isJsonNull()) {
                    strMeasure19 = mealObject.get("strMeasure19").getAsString();
                }
                String strMeasure20 = "";
                if (!mealObject.get("strMeasure20").isJsonNull()) {
                    strMeasure20 = mealObject.get("strMeasure20").getAsString();
                }


                model.addAttribute("idmeal", idMeal);
                model.addAttribute("strMeal", strMeal);
                model.addAttribute("strCategory", strCategory);
                model.addAttribute("strInstructions", strInstructions);
                model.addAttribute("strYoutube", strYoutube);
                model.addAttribute("strMealThumb", strMealThumb);
                model.addAttribute("strIngredient1", strIngredient1);
                model.addAttribute("strIngredient2", strIngredient2);
                model.addAttribute("strIngredient3", strIngredient3);
                model.addAttribute("strIngredient4", strIngredient4);
                model.addAttribute("strIngredient5", strIngredient5);
                model.addAttribute("strIngredient6", strIngredient6);
                model.addAttribute("strIngredient7", strIngredient7);
                model.addAttribute("strIngredient8", strIngredient8);
                model.addAttribute("strIngredient9", strIngredient9);
                model.addAttribute("strIngredient10", strIngredient10);
                model.addAttribute("strIngredient11", strIngredient11);
                model.addAttribute("strIngredient12", strIngredient12);
                model.addAttribute("strIngredient13", strIngredient13);
                model.addAttribute("strIngredient14", strIngredient14);
                model.addAttribute("strIngredient15", strIngredient15);
                model.addAttribute("strIngredient16", strIngredient16);
                model.addAttribute("strIngredient17", strIngredient17);
                model.addAttribute("strIngredient18", strIngredient18);
                model.addAttribute("strIngredient19", strIngredient19);
                model.addAttribute("strIngredient20", strIngredient20);
                model.addAttribute("strMeasure1", strMeasure1);
                model.addAttribute("strMeasure2", strMeasure2);
                model.addAttribute("strMeasure3", strMeasure3);
                model.addAttribute("strMeasure4", strMeasure4);
                model.addAttribute("strMeasure5", strMeasure5);
                model.addAttribute("strMeasure6", strMeasure6);
                model.addAttribute("strMeasure7", strMeasure7);
                model.addAttribute("strMeasure8", strMeasure8);
                model.addAttribute("strMeasure9", strMeasure9);
                model.addAttribute("strMeasure10", strMeasure10);
                model.addAttribute("strMeasure11", strMeasure11);
                model.addAttribute("strMeasure12", strMeasure12);
                model.addAttribute("strMeasure13", strMeasure13);
                model.addAttribute("strMeasure14", strMeasure14);
                model.addAttribute("strMeasure15", strMeasure15);
                model.addAttribute("strMeasure16", strMeasure16);
                model.addAttribute("strMeasure17", strMeasure17);
                model.addAttribute("strMeasure18", strMeasure18);
                model.addAttribute("strMeasure19", strMeasure19);
                model.addAttribute("strMeasure20", strMeasure20);

                Optional<Recipe> existingRecipe = Optional.ofNullable(recipeRepository.findByIdMeal(Long.parseLong(idMeal)));
                if (!existingRecipe.isPresent()) {
                    Recipe newRecipe = new Recipe();
                    newRecipe.setIdMeal(Long.parseLong(idMeal));
                    newRecipe.setStrMeal(strMeal);
                    newRecipe.setStrCategory(strCategory);
                    newRecipe.setStrMealThumb(strMealThumb);
                    recipeRepository.save(newRecipe);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "showRecipe";

    }

    @GetMapping("/recipe/{id}/ari")
    public String addRecipeIngredientsToGrocery(@PathVariable int id, Model model) {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDao.getReferenceById(loggedInUser.getId());
        List<Ingredient> usersGroceries = new ArrayList<>(user.getGroceryItems().stream().toList());

        try {
            if (usersGroceries.isEmpty()) {
                usersGroceries.addAll(ingredients);
            } else {
                int i = 0;
                while (i < ingredients.size()) {
                    if (!ingredients.get(i).getName().equals(usersGroceries.get(i).getName())) {
                        System.out.println("**********************");
                        System.out.println(ingredients.get(i));
                        System.out.println(usersGroceries);
                        System.out.println("**********************");

                        usersGroceries.add(ingredients.get(i));


                        System.out.println("----------------------");
                        System.out.println(usersGroceries);
                        System.out.println("----------------------");

                        i++;
                    }
                }
            }

            user.setGroceryItems(usersGroceries);
            userDao.save(user);

            ingredients.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/user";
    }
}
