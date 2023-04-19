package com.outofmilk.outofmilk.controllers;

import com.google.gson.*;
import com.outofmilk.outofmilk.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestController {

    @Value("MEALDB_API_KEY")
    private String apiKey;

    @Autowired
    private RecipeRepository recipeRepository;

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
                if (mealObject.get("strYoutube").isJsonNull() == false) {
                    strYoutube = mealObject.get("strYoutube").getAsString();
                }

                String strIngredient1 = "";
                if (mealObject.get("strIngredient1").isJsonNull() == false) {
                    strIngredient1 = mealObject.get("strIngredient1").getAsString();
                }

                String strIngredient2 = "";
                if (mealObject.get("strIngredient2").isJsonNull() == false) {
                    strIngredient2 = mealObject.get("strIngredient2").getAsString();
                }

                String strIngredient3 = "";
                if (mealObject.get("strIngredient3").isJsonNull() == false) {
                    strIngredient3 = mealObject.get("strIngredient3").getAsString();
                }

                String strIngredient4 = "";
                if (mealObject.get("strIngredient4").isJsonNull() == false) {
                    strIngredient4 = mealObject.get("strIngredient4").getAsString();
                }

                String strIngredient5 = "";
                if (mealObject.get("strIngredient5").isJsonNull() == false) {
                    strIngredient5 = mealObject.get("strIngredient5").getAsString();
                }

                String strIngredient6 = "";
                if (mealObject.get("strIngredient6").isJsonNull() == false) {
                    strIngredient6 = mealObject.get("strIngredient6").getAsString();
                }
                String strIngredient7 = "";
                if (mealObject.get("strIngredient7").isJsonNull() == false) {
                    strIngredient7 = mealObject.get("strIngredient7").getAsString();
                }
                String strIngredient8 = "";
                if (mealObject.get("strIngredient8").isJsonNull() == false) {
                    strIngredient8 = mealObject.get("strIngredient8").getAsString();
                }
                String strIngredient9 = "";
                if (mealObject.get("strIngredient1").isJsonNull() == false) {
                    strIngredient9 = mealObject.get("strIngredient9").getAsString();
                }
                String strIngredient10 = "";
                if (mealObject.get("strIngredient10").isJsonNull() == false) {
                    strIngredient10 = mealObject.get("strIngredient10").getAsString();
                }
                String strIngredient11 = "";
                if (mealObject.get("strIngredient11").isJsonNull() == false) {
                    strIngredient11 = mealObject.get("strIngredient11").getAsString();
                }
                String strIngredient12 = "";
                if (mealObject.get("strIngredient12").isJsonNull() == false) {
                    strIngredient12 = mealObject.get("strIngredient12").getAsString();
                }
                String strIngredient13 = "";
                if (mealObject.get("strIngredient13").isJsonNull() == false) {
                    strIngredient13 = mealObject.get("strIngredient13").getAsString();
                }
                String strIngredient14 = "";
                if (mealObject.get("strIngredient14").isJsonNull() == false) {
                    strIngredient14 = mealObject.get("strIngredient14").getAsString();
                }
                String strIngredient15 = "";
                if (mealObject.get("strIngredient15").isJsonNull() == false) {
                    strIngredient15 = mealObject.get("strIngredient15").getAsString();
                }
                String strIngredient16 = "";
                if (mealObject.get("strIngredient16").isJsonNull() == false) {
                    strIngredient16 = mealObject.get("strIngredient16").getAsString();
                }
                String strIngredient17 = "";
                if (mealObject.get("strIngredient17").isJsonNull() == false) {
                    strIngredient17 = mealObject.get("strIngredient17").getAsString();
                }
                String strIngredient18 = "";
                if (mealObject.get("strIngredient18").isJsonNull() == false) {
                    strIngredient18 = mealObject.get("strIngredient18").getAsString();
                }
                String strIngredient19 = "";
                if (mealObject.get("strIngredient19").isJsonNull() == false) {
                    strIngredient19 = mealObject.get("strIngredient19").getAsString();
                }
                String strIngredient20 = "";
                if (mealObject.get("strIngredient20").isJsonNull() == false) {
                    strIngredient20 = mealObject.get("strIngredient20").getAsString();
                }

                String strMeasure1 = "";
                if (mealObject.get("strMeasure1").isJsonNull() == false) {
                    strMeasure1 = mealObject.get("strMeasure1").getAsString();
                }
                String strMeasure2 = "";
                if (mealObject.get("strMeasure2").isJsonNull() == false) {
                    strMeasure2 = mealObject.get("strMeasure2").getAsString();
                }
                String strMeasure3 = "";
                if (mealObject.get("strMeasure3").isJsonNull() == false) {
                    strMeasure3 = mealObject.get("strMeasure3").getAsString();
                }
                String strMeasure4 = "";
                if (mealObject.get("strMeasure4").isJsonNull() == false) {
                    strMeasure4 = mealObject.get("strMeasure4").getAsString();
                }
                String strMeasure5 = "";
                if (mealObject.get("strMeasure5").isJsonNull() == false) {
                    strMeasure5 = mealObject.get("strMeasure5").getAsString();
                }
                String strMeasure6 = "";
                if (mealObject.get("strMeasure6").isJsonNull() == false) {
                    strMeasure6 = mealObject.get("strMeasure6").getAsString();
                }
                String strMeasure7 = "";
                if (mealObject.get("strMeasure7").isJsonNull() == false) {
                    strMeasure7 = mealObject.get("strMeasure7").getAsString();
                }
                String strMeasure8 = "";
                if (mealObject.get("strMeasure8").isJsonNull() == false) {
                    strMeasure8 = mealObject.get("strMeasure8").getAsString();
                }
                String strMeasure9 = "";
                if (mealObject.get("strMeasure9").isJsonNull() == false) {
                    strMeasure9 = mealObject.get("strMeasure9").getAsString();
                }
                String strMeasure10 = "";
                if (mealObject.get("strMeasure10").isJsonNull() == false) {
                    strMeasure10 = mealObject.get("strMeasure10").getAsString();
                }
                String strMeasure11 = "";
                if (mealObject.get("strMeasure11").isJsonNull() == false) {
                    strMeasure11 = mealObject.get("strMeasure11").getAsString();
                }
                String strMeasure12 = "";
                if (mealObject.get("strMeasure12").isJsonNull() == false) {
                    strMeasure12 = mealObject.get("strMeasure12").getAsString();
                }
                String strMeasure13 = "";
                if (mealObject.get("strMeasure13").isJsonNull() == false) {
                    strMeasure13 = mealObject.get("strMeasure13").getAsString();
                }
                String strMeasure14 = "";
                if (mealObject.get("strMeasure14").isJsonNull() == false) {
                    strMeasure14 = mealObject.get("strMeasure14").getAsString();
                }
                String strMeasure15 = "";
                if (mealObject.get("strMeasure15").isJsonNull() == false) {
                    strMeasure15 = mealObject.get("strMeasure15").getAsString();
                }
                String strMeasure16 = "";
                if (mealObject.get("strMeasure16").isJsonNull() == false) {
                    strMeasure16 = mealObject.get("strMeasure16").getAsString();
                }
                String strMeasure17 = "";
                if (mealObject.get("strMeasure17").isJsonNull() == false) {
                    strMeasure17 = mealObject.get("strMeasure17").getAsString();
                }
                String strMeasure18 = "";
                if (mealObject.get("strMeasure18").isJsonNull() == false) {
                    strMeasure18 = mealObject.get("strMeasure18").getAsString();
                }
                String strMeasure19 = "";
                if (mealObject.get("strMeasure19").isJsonNull() == false) {
                    strMeasure19 = mealObject.get("strMeasure19").getAsString();
                }
                String strMeasure20 = "";
                if (mealObject.get("strMeasure20").isJsonNull() == false) {
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


//                Optional<Recipe> existingRecipe = Optional.ofNullable(recipeRepository.findByIdMeal(Long.parseLong(idMeal)));
//                if (!existingRecipe.isPresent()) {
//
//                    Recipe newRecipe = new Recipe();
//                    newRecipe.setIdMeal(Long.parseLong(idMeal));
//                    newRecipe.setStrMeal(strMeal);
//                    newRecipe.setStrCategory(strCategory);
//                    newRecipe.setStrMealThumb(strMealThumb);
//
//                    recipeRepository.save(newRecipe);
//                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "showRecipe";

    }


}
