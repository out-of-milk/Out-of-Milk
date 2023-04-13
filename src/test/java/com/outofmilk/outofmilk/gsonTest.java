package com.outofmilk.outofmilk;

import com.google.gson.Gson;
import com.outofmilk.outofmilk.models.Meal;
import com.outofmilk.outofmilk.models.Simple;
import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.spring6.context.SpringContextUtils;

@SpringBootTest
public class gsonTest {
    Gson gson = new Gson();

    @Test
    public void bigJSONString() {
        String json = """
                      {
                         "idMeal":"53065",
                         "strMeal":"Sushi",
                         "strDrinkAlternate":null,
                         "strCategory":"Seafood",
                         "strArea":"Japanese",
                         "strInstructions":"STEP 1\\\\r\\\\nTO MAKE SUSHI ROLLS: Pat out some rice. Lay a nori sheet on the mat, shiny-side down. Dip your hands in the vinegared water, then pat handfuls of rice on top in a 1cm thick layer, leaving the furthest edge from you clear.\\\\r\\\\n\\\\r\\\\nSTEP 2\\\\r\\\\nSpread over some Japanese mayonnaise. Use a spoon to spread out a thin layer of mayonnaise down the middle of the rice.\\\\r\\\\n\\\\r\\\\nSTEP 3\\\\r\\\\nAdd the filling. Get your child to top the mayonnaise with a line of their favourite fillings \\\\u2013 here we\\\\u2019ve used tuna and cucumber.\\\\r\\\\n\\\\r\\\\nSTEP 4\\\\r\\\\nRoll it up. Lift the edge of the mat over the rice, applying a little pressure to keep everything in a tight roll.\\\\r\\\\n\\\\r\\\\nSTEP 5\\\\r\\\\nStick down the sides like a stamp. When you get to the edge without any rice, brush with a little water and continue to roll into a tight roll.\\\\r\\\\n\\\\r\\\\nSTEP 6\\\\r\\\\nWrap in cling film. Remove the mat and roll tightly in cling film before a grown-up cuts the sushi into thick slices, then unravel the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 7\\\\r\\\\nTO MAKE PRESSED SUSHI: Layer over some smoked salmon. Line a loaf tin with cling film, then place a thin layer of smoked salmon inside on top of the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 8\\\\r\\\\nCover with rice and press down. Press about 3cm of rice over the fish, fold the cling film over and press down as much as you can, using another tin if you have one.\\\\r\\\\n\\\\r\\\\nSTEP 9\\\\r\\\\nTip it out like a sandcastle. Turn block of sushi onto a chopping board. Get a grown-up to cut into fingers, then remove the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 10\\\\r\\\\nTO MAKE SUSHI BALLS: Choose your topping. Get a small square of cling film and place a topping, like half a prawn or a small piece of smoked salmon, on it. Use damp hands to roll walnut-sized balls of rice and place on the topping.\\\\r\\\\n\\\\r\\\\nSTEP 11\\\\r\\\\nMake into tight balls. Bring the corners of the cling film together and tighten into balls by twisting it up, then unwrap and serve.",
                         "strMealThumb":"https:\\\\/\\\\/www.themealdb.com\\\\/images\\\\/media\\\\/meals\\\\/g046bb1663960946.jpg",
                         "strTags":null,
                         "strYoutube":"https:\\\\/\\\\/www.youtube.com\\\\/watch?v=ub68OxEypaY",
                         "strIngredient1":"Sushi Rice",
                         "strIngredient2":"Rice wine",
                         "strIngredient3":"Caster Sugar",
                         "strIngredient4":"Mayonnaise",
                         "strIngredient5":"Rice wine",
                         "strIngredient6":"Soy Sauce",
                         "strIngredient7":"Cucumber",
                         "strIngredient8":"",
                         "strIngredient9":"",
                         "strIngredient10":"",
                         "strIngredient11":"",
                         "strIngredient12":"",
                         "strIngredient13":"",
                         "strIngredient14":"",
                         "strIngredient15":"",
                         "strIngredient16":"",
                         "strIngredient17":"",
                         "strIngredient18":"",
                         "strIngredient19":"",
                         "strIngredient20":"",
                         "strMeasure1":"300ml ",
                         "strMeasure2":"100ml",
                         "strMeasure3":"2 tbs",
                         "strMeasure4":"3 tbs",
                         "strMeasure5":"1 tbs",
                         "strMeasure6":"1 tbs",
                         "strMeasure7":"1",
                         "strMeasure8":" ",
                         "strMeasure9":" ",
                         "strMeasure10":" ",
                         "strMeasure11":" ",
                         "strMeasure12":" ",
                         "strMeasure13":" ",
                         "strMeasure14":" ",
                         "strMeasure15":" ",
                         "strMeasure16":" ",
                         "strMeasure17":" ",
                         "strMeasure18":" ",
                         "strMeasure19":" ",
                         "strMeasure20":" ",
                         "strSource":"https:\\\\/\\\\/www.bbcgoodfood.com\\\\/recipes\\\\/simple-sushi",
                         "strImageSource":null,
                         "strCreativeCommonsConfirmed":null,
                         "dateModified":null
                      }
                """;
        Meal meal = gson.fromJson(json, Meal.class);
        System.out.println(meal);
    }

    @Test
    public void littleTest(){
        String json =  """
        {
         "string1":"hello",
         "string2":"world",
         "int1":"42"
        }
         """;
        Simple simple = gson.fromJson(json, Simple.class);
        System.out.println(simple);
    }

    @Test
    public void objectTest(){
        String json = """
                  { "meals":
                    [{
                         "idMeal":"53065",
                         "strMeal":"Sushi",
                         "strDrinkAlternate":null,
                         "strCategory":"Seafood",
                         "strArea":"Japanese",
                         "strInstructions":"STEP 1\\\\r\\\\nTO MAKE SUSHI ROLLS: Pat out some rice. Lay a nori sheet on the mat, shiny-side down. Dip your hands in the vinegared water, then pat handfuls of rice on top in a 1cm thick layer, leaving the furthest edge from you clear.\\\\r\\\\n\\\\r\\\\nSTEP 2\\\\r\\\\nSpread over some Japanese mayonnaise. Use a spoon to spread out a thin layer of mayonnaise down the middle of the rice.\\\\r\\\\n\\\\r\\\\nSTEP 3\\\\r\\\\nAdd the filling. Get your child to top the mayonnaise with a line of their favourite fillings \\\\u2013 here we\\\\u2019ve used tuna and cucumber.\\\\r\\\\n\\\\r\\\\nSTEP 4\\\\r\\\\nRoll it up. Lift the edge of the mat over the rice, applying a little pressure to keep everything in a tight roll.\\\\r\\\\n\\\\r\\\\nSTEP 5\\\\r\\\\nStick down the sides like a stamp. When you get to the edge without any rice, brush with a little water and continue to roll into a tight roll.\\\\r\\\\n\\\\r\\\\nSTEP 6\\\\r\\\\nWrap in cling film. Remove the mat and roll tightly in cling film before a grown-up cuts the sushi into thick slices, then unravel the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 7\\\\r\\\\nTO MAKE PRESSED SUSHI: Layer over some smoked salmon. Line a loaf tin with cling film, then place a thin layer of smoked salmon inside on top of the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 8\\\\r\\\\nCover with rice and press down. Press about 3cm of rice over the fish, fold the cling film over and press down as much as you can, using another tin if you have one.\\\\r\\\\n\\\\r\\\\nSTEP 9\\\\r\\\\nTip it out like a sandcastle. Turn block of sushi onto a chopping board. Get a grown-up to cut into fingers, then remove the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 10\\\\r\\\\nTO MAKE SUSHI BALLS: Choose your topping. Get a small square of cling film and place a topping, like half a prawn or a small piece of smoked salmon, on it. Use damp hands to roll walnut-sized balls of rice and place on the topping.\\\\r\\\\n\\\\r\\\\nSTEP 11\\\\r\\\\nMake into tight balls. Bring the corners of the cling film together and tighten into balls by twisting it up, then unwrap and serve.",
                         "strMealThumb":"https:\\\\/\\\\/www.themealdb.com\\\\/images\\\\/media\\\\/meals\\\\/g046bb1663960946.jpg",
                         "strTags":null,
                         "strYoutube":"https:\\\\/\\\\/www.youtube.com\\\\/watch?v=ub68OxEypaY",
                         "strIngredient1":"Sushi Rice",
                         "strIngredient2":"Rice wine",
                         "strIngredient3":"Caster Sugar",
                         "strIngredient4":"Mayonnaise",
                         "strIngredient5":"Rice wine",
                         "strIngredient6":"Soy Sauce",
                         "strIngredient7":"Cucumber",
                         "strIngredient8":"",
                         "strIngredient9":"",
                         "strIngredient10":"",
                         "strIngredient11":"",
                         "strIngredient12":"",
                         "strIngredient13":"",
                         "strIngredient14":"",
                         "strIngredient15":"",
                         "strIngredient16":"",
                         "strIngredient17":"",
                         "strIngredient18":"",
                         "strIngredient19":"",
                         "strIngredient20":"",
                         "strMeasure1":"300ml ",
                         "strMeasure2":"100ml",
                         "strMeasure3":"2 tbs",
                         "strMeasure4":"3 tbs",
                         "strMeasure5":"1 tbs",
                         "strMeasure6":"1 tbs",
                         "strMeasure7":"1",
                         "strMeasure8":" ",
                         "strMeasure9":" ",
                         "strMeasure10":" ",
                         "strMeasure11":" ",
                         "strMeasure12":" ",
                         "strMeasure13":" ",
                         "strMeasure14":" ",
                         "strMeasure15":" ",
                         "strMeasure16":" ",
                         "strMeasure17":" ",
                         "strMeasure18":" ",
                         "strMeasure19":" ",
                         "strMeasure20":" ",
                         "strSource":"https:\\\\/\\\\/www.bbcgoodfood.com\\\\/recipes\\\\/simple-sushi",
                         "strImageSource":null,
                         "strCreativeCommonsConfirmed":null,
                         "dateModified":null
                    }]
                  }
                """;
        Meal meal = gson.fromJson(json, Meal.class);
        System.out.println(meal);
    }

    @Test
    public void arrayTest() {
        String json = """
                  {[{
                         "idMeal":"53065",
                         "strMeal":"Sushi",
                         "strDrinkAlternate":null,
                         "strCategory":"Seafood",
                         "strArea":"Japanese",
                         "strInstructions":"STEP 1\\\\r\\\\nTO MAKE SUSHI ROLLS: Pat out some rice. Lay a nori sheet on the mat, shiny-side down. Dip your hands in the vinegared water, then pat handfuls of rice on top in a 1cm thick layer, leaving the furthest edge from you clear.\\\\r\\\\n\\\\r\\\\nSTEP 2\\\\r\\\\nSpread over some Japanese mayonnaise. Use a spoon to spread out a thin layer of mayonnaise down the middle of the rice.\\\\r\\\\n\\\\r\\\\nSTEP 3\\\\r\\\\nAdd the filling. Get your child to top the mayonnaise with a line of their favourite fillings \\\\u2013 here we\\\\u2019ve used tuna and cucumber.\\\\r\\\\n\\\\r\\\\nSTEP 4\\\\r\\\\nRoll it up. Lift the edge of the mat over the rice, applying a little pressure to keep everything in a tight roll.\\\\r\\\\n\\\\r\\\\nSTEP 5\\\\r\\\\nStick down the sides like a stamp. When you get to the edge without any rice, brush with a little water and continue to roll into a tight roll.\\\\r\\\\n\\\\r\\\\nSTEP 6\\\\r\\\\nWrap in cling film. Remove the mat and roll tightly in cling film before a grown-up cuts the sushi into thick slices, then unravel the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 7\\\\r\\\\nTO MAKE PRESSED SUSHI: Layer over some smoked salmon. Line a loaf tin with cling film, then place a thin layer of smoked salmon inside on top of the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 8\\\\r\\\\nCover with rice and press down. Press about 3cm of rice over the fish, fold the cling film over and press down as much as you can, using another tin if you have one.\\\\r\\\\n\\\\r\\\\nSTEP 9\\\\r\\\\nTip it out like a sandcastle. Turn block of sushi onto a chopping board. Get a grown-up to cut into fingers, then remove the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 10\\\\r\\\\nTO MAKE SUSHI BALLS: Choose your topping. Get a small square of cling film and place a topping, like half a prawn or a small piece of smoked salmon, on it. Use damp hands to roll walnut-sized balls of rice and place on the topping.\\\\r\\\\n\\\\r\\\\nSTEP 11\\\\r\\\\nMake into tight balls. Bring the corners of the cling film together and tighten into balls by twisting it up, then unwrap and serve.",
                         "strMealThumb":"https:\\\\/\\\\/www.themealdb.com\\\\/images\\\\/media\\\\/meals\\\\/g046bb1663960946.jpg",
                         "strTags":null,
                         "strYoutube":"https:\\\\/\\\\/www.youtube.com\\\\/watch?v=ub68OxEypaY",
                         "strIngredient1":"Sushi Rice",
                         "strIngredient2":"Rice wine",
                         "strIngredient3":"Caster Sugar",
                         "strIngredient4":"Mayonnaise",
                         "strIngredient5":"Rice wine",
                         "strIngredient6":"Soy Sauce",
                         "strIngredient7":"Cucumber",
                         "strIngredient8":"",
                         "strIngredient9":"",
                         "strIngredient10":"",
                         "strIngredient11":"",
                         "strIngredient12":"",
                         "strIngredient13":"",
                         "strIngredient14":"",
                         "strIngredient15":"",
                         "strIngredient16":"",
                         "strIngredient17":"",
                         "strIngredient18":"",
                         "strIngredient19":"",
                         "strIngredient20":"",
                         "strMeasure1":"300ml ",
                         "strMeasure2":"100ml",
                         "strMeasure3":"2 tbs",
                         "strMeasure4":"3 tbs",
                         "strMeasure5":"1 tbs",
                         "strMeasure6":"1 tbs",
                         "strMeasure7":"1",
                         "strMeasure8":" ",
                         "strMeasure9":" ",
                         "strMeasure10":" ",
                         "strMeasure11":" ",
                         "strMeasure12":" ",
                         "strMeasure13":" ",
                         "strMeasure14":" ",
                         "strMeasure15":" ",
                         "strMeasure16":" ",
                         "strMeasure17":" ",
                         "strMeasure18":" ",
                         "strMeasure19":" ",
                         "strMeasure20":" ",
                         "strSource":"https:\\\\/\\\\/www.bbcgoodfood.com\\\\/recipes\\\\/simple-sushi",
                         "strImageSource":null,
                         "strCreativeCommonsConfirmed":null,
                         "dateModified":null
                    }]}
                """;
        Meal meal = gson.fromJson(json, Meal.class);
        System.out.println(meal);
    }
    @Test
    public void objectArrayTest() {
        String json = """
                  {"meals":
                    [{
                         "idMeal":"53065",
                         "strMeal":"Sushi",
                         "strDrinkAlternate":null,
                         "strCategory":"Seafood",
                         "strArea":"Japanese",
                         "strInstructions":"STEP 1\\\\r\\\\nTO MAKE SUSHI ROLLS: Pat out some rice. Lay a nori sheet on the mat, shiny-side down. Dip your hands in the vinegared water, then pat handfuls of rice on top in a 1cm thick layer, leaving the furthest edge from you clear.\\\\r\\\\n\\\\r\\\\nSTEP 2\\\\r\\\\nSpread over some Japanese mayonnaise. Use a spoon to spread out a thin layer of mayonnaise down the middle of the rice.\\\\r\\\\n\\\\r\\\\nSTEP 3\\\\r\\\\nAdd the filling. Get your child to top the mayonnaise with a line of their favourite fillings \\\\u2013 here we\\\\u2019ve used tuna and cucumber.\\\\r\\\\n\\\\r\\\\nSTEP 4\\\\r\\\\nRoll it up. Lift the edge of the mat over the rice, applying a little pressure to keep everything in a tight roll.\\\\r\\\\n\\\\r\\\\nSTEP 5\\\\r\\\\nStick down the sides like a stamp. When you get to the edge without any rice, brush with a little water and continue to roll into a tight roll.\\\\r\\\\n\\\\r\\\\nSTEP 6\\\\r\\\\nWrap in cling film. Remove the mat and roll tightly in cling film before a grown-up cuts the sushi into thick slices, then unravel the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 7\\\\r\\\\nTO MAKE PRESSED SUSHI: Layer over some smoked salmon. Line a loaf tin with cling film, then place a thin layer of smoked salmon inside on top of the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 8\\\\r\\\\nCover with rice and press down. Press about 3cm of rice over the fish, fold the cling film over and press down as much as you can, using another tin if you have one.\\\\r\\\\n\\\\r\\\\nSTEP 9\\\\r\\\\nTip it out like a sandcastle. Turn block of sushi onto a chopping board. Get a grown-up to cut into fingers, then remove the cling film.\\\\r\\\\n\\\\r\\\\nSTEP 10\\\\r\\\\nTO MAKE SUSHI BALLS: Choose your topping. Get a small square of cling film and place a topping, like half a prawn or a small piece of smoked salmon, on it. Use damp hands to roll walnut-sized balls of rice and place on the topping.\\\\r\\\\n\\\\r\\\\nSTEP 11\\\\r\\\\nMake into tight balls. Bring the corners of the cling film together and tighten into balls by twisting it up, then unwrap and serve.",
                         "strMealThumb":"https:\\\\/\\\\/www.themealdb.com\\\\/images\\\\/media\\\\/meals\\\\/g046bb1663960946.jpg",
                         "strTags":null,
                         "strYoutube":"https:\\\\/\\\\/www.youtube.com\\\\/watch?v=ub68OxEypaY",
                         "strIngredient1":"Sushi Rice",
                         "strIngredient2":"Rice wine",
                         "strIngredient3":"Caster Sugar",
                         "strIngredient4":"Mayonnaise",
                         "strIngredient5":"Rice wine",
                         "strIngredient6":"Soy Sauce",
                         "strIngredient7":"Cucumber",
                         "strIngredient8":"",
                         "strIngredient9":"",
                         "strIngredient10":"",
                         "strIngredient11":"",
                         "strIngredient12":"",
                         "strIngredient13":"",
                         "strIngredient14":"",
                         "strIngredient15":"",
                         "strIngredient16":"",
                         "strIngredient17":"",
                         "strIngredient18":"",
                         "strIngredient19":"",
                         "strIngredient20":"",
                         "strMeasure1":"300ml ",
                         "strMeasure2":"100ml",
                         "strMeasure3":"2 tbs",
                         "strMeasure4":"3 tbs",
                         "strMeasure5":"1 tbs",
                         "strMeasure6":"1 tbs",
                         "strMeasure7":"1",
                         "strMeasure8":" ",
                         "strMeasure9":" ",
                         "strMeasure10":" ",
                         "strMeasure11":" ",
                         "strMeasure12":" ",
                         "strMeasure13":" ",
                         "strMeasure14":" ",
                         "strMeasure15":" ",
                         "strMeasure16":" ",
                         "strMeasure17":" ",
                         "strMeasure18":" ",
                         "strMeasure19":" ",
                         "strMeasure20":" ",
                         "strSource":"https:\\\\/\\\\/www.bbcgoodfood.com\\\\/recipes\\\\/simple-sushi",
                         "strImageSource":null,
                         "strCreativeCommonsConfirmed":null,
                         "dateModified":null
                    }]
                  }
                """;
        Gson gson = new Gson();
        Meal[] meals = gson.fromJson(json, Meal[].class);
    }

}
