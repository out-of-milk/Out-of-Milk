package com.outofmilk.outofmilk.controllers;

import com.google.gson.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class RecipeController {


    @GetMapping("/")
    public String showFindAllForm(Model model){
        String jsonResponse = null;
        try {
            URL url = new URL("https://www.themealdb.com/api/json/v1//random.php");
//           put key inside
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
                System.out.println(idMeal);
                String strMeal = mealObject.get("strMeal").getAsString();
                String strCategory = mealObject.get("strCategory").getAsString();
                String strMealThumb = mealObject.get("strMealThumb").getAsString();

                model.addAttribute("idmeal", idMeal);
                model.addAttribute("strMeal", strMeal);
                model.addAttribute("strCategory", strCategory);
                model.addAttribute("strMealThumb", strMealThumb);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "findAll";
    }




}
