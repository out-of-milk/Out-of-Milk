package com.outofmilk.outofmilk.controllers;

import com.google.gson.*;
import com.outofmilk.outofmilk.models.Meal;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Controller
public class RestController {

    @GetMapping("/recipe/{id}")
    public String callExternalApi(@PathVariable int id, Model model) {
        String jsonResponse = null;
        try {
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "text/plain");
            connection.setRequestMethod("GET");
//            connection.getOutputStream().write(pic);
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

                String strIngredient1 = "";
                if(mealObject.get("strIngredient1").isJsonNull() == false){
                    strIngredient1 = mealObject.get("strIngredient1").getAsString();
                }

                String strIngredient2 = "";
                if(mealObject.get("strIngredient2").isJsonNull() == false){
                    strIngredient2 = mealObject.get("strIngredient2").getAsString();
                }

                String strIngredient3 = "";
                if(mealObject.get("strIngredient3").isJsonNull() == false){
                    strIngredient3 = mealObject.get("strIngredient3").getAsString();
                }

                String strIngredient4 = "";
                if(mealObject.get("strIngredient4").isJsonNull() == false){
                    strIngredient4 = mealObject.get("strIngredient4").getAsString();
                }

                String strIngredient5 = "";
                if(mealObject.get("strIngredient5").isJsonNull() == false){
                    strIngredient5 = mealObject.get("strIngredient5").getAsString();
                }

                String strIngredient6 = "";
                if(mealObject.get("strIngredient6").isJsonNull() == false){
                    strIngredient6 = mealObject.get("strIngredient6").getAsString();
                }
                String strIngredient7 = "";
                if(mealObject.get("strIngredient7").isJsonNull() == false){
                    strIngredient7 = mealObject.get("strIngredient7").getAsString();
                }
                String strIngredient8 = "";
                if(mealObject.get("strIngredient8").isJsonNull() == false){
                    strIngredient8 = mealObject.get("strIngredient8").getAsString();
                }
                String strIngredient9 = "";
                if(mealObject.get("strIngredient1").isJsonNull() == false){
                    strIngredient9 = mealObject.get("strIngredient9").getAsString();
                }
                String strIngredient10 = "";
                if(mealObject.get("strIngredient10").isJsonNull() == false){
                    strIngredient10 = mealObject.get("strIngredient10").getAsString();
                }
                String strIngredient11 = "";
                if(mealObject.get("strIngredient11").isJsonNull() == false){
                    strIngredient11 = mealObject.get("strIngredient11").getAsString();
                }
                String strIngredient12 = "";
                if(mealObject.get("strIngredient12").isJsonNull() == false){
                    strIngredient12 = mealObject.get("strIngredient12").getAsString();
                }
                String strIngredient13 = "";
                if(mealObject.get("strIngredient13").isJsonNull() == false){
                    strIngredient13 = mealObject.get("strIngredient13").getAsString();
                }
                String strIngredient14 = "";
                if(mealObject.get("strIngredient14").isJsonNull() == false){
                    strIngredient14 = mealObject.get("strIngredient14").getAsString();
                }
                String strIngredient15 = "";
                if(mealObject.get("strIngredient15").isJsonNull() == false){
                    strIngredient15 = mealObject.get("strIngredient15").getAsString();
                }
                String strIngredient16 = "";
                if(mealObject.get("strIngredient16").isJsonNull() == false){
                    strIngredient16 = mealObject.get("strIngredient16").getAsString();
                }
                String strIngredient17 = "";
                if(mealObject.get("strIngredient17").isJsonNull() == false){
                    strIngredient17 = mealObject.get("strIngredient17").getAsString();
                }
                String strIngredient18 = "";
                if(mealObject.get("strIngredient18").isJsonNull() == false){
                    strIngredient18 = mealObject.get("strIngredient18").getAsString();
                }
                String strIngredient19 = "";
                if(mealObject.get("strIngredient19").isJsonNull() == false){
                    strIngredient19 = mealObject.get("strIngredient19").getAsString();
                }
                String strIngredient20 = "";
                if(mealObject.get("strIngredient20").isJsonNull() == false){
                    strIngredient20 = mealObject.get("strIngredient20").getAsString();
                }
                String strMeasure1 = mealObject.get("strMeasure1").getAsString();

                model.addAttribute("idmeal", idMeal);
                model.addAttribute("strMeal", strMeal);
                model.addAttribute("strCategory", strCategory);
                model.addAttribute("strInstructions", strInstructions);
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
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "showRecipe";

    }
}
