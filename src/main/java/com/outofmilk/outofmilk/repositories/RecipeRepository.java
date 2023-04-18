package com.outofmilk.outofmilk.repositories;

import com.outofmilk.outofmilk.models.Recipe;
import com.outofmilk.outofmilk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByIdMeal(long id_Meal);

//    @Query(value = "SELECT * FROM recipes ORDER BY RAND() LIMIT :amount", nativeQuery = true)
//    List<Recipe> selectRecommendedRecipes(@Param("amount") String amount);

    @Query(value = "SELECT * FROM recipes ORDER BY RAND() LIMIT :amount", nativeQuery = true)
    List<Recipe> selectRandomRecipes(@Param("amount") Long amount);

}
