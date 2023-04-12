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

    @GetMapping(value ="/recipe/{id}",  produces = "application/json")
    @ResponseBody
    public String callExternalApi(@PathVariable int id, Model model) {

        String jsonResponse = null;
        try {
            URL url = new URL("https://www.themealdb.com/api/json/v1/1/lookup.php?i=53065");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "text/plain");
            connection.setRequestMethod("GET");
//            connection.getOutputStream().write(pic);
            connection.getResponseCode();
            jsonResponse = new String(connection.getInputStream().readAllBytes());
            System.out.println("HTTP response code is " + connection.getResponseCode());
            System.out.println(jsonResponse);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            jsonResponse = gson.toJson(jsonResponse);
            System.out.println(jsonResponse);

//            JsonParser parser = new JsonParser();
//            JsonElement rootNode = parser.parse(jsonResponse);
//            if (rootNode.isJsonObject()) {
//                JsonObject details = rootNode.getAsJsonObject();
//                JsonElement nameNode = details.get("strMeal");
//                System.out.println("Name/strMeal: " +nameNode.getAsString());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonResponse;

    }
}
