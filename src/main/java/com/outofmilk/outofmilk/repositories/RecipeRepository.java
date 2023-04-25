package com.outofmilk.outofmilk.repositories;

import com.outofmilk.outofmilk.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByIdMeal(long id_Meal);

    List<Recipe> findByStrCategoryIn(List<String> categories);
    @Query(value = "SELECT * FROM recipes ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Recipe> selectRandomRecipes();

    @Query(value = "SELECT * FROM recipes ORDER BY RAND() LIMIT :amount", nativeQuery = true)
    List<Recipe> selectRandomRecipes(@Param("amount") Long amount);

    @Query(value = "SELECT COUNT(*) FROM recipe_preferences WHERE favorite = true and recipe_id = :recipe_id", nativeQuery = true)
    long recipeLikes(@Param("recipe_id") int recipe_id);

    @Query(value = "SELECT COUNT(*) FROM recipe_preferences WHERE user_id = :userId AND recipe_id = :recipe_id AND favorite = true", nativeQuery = true)
    long findRecipeLiked(@Param("userId") long user,
                         @Param("recipe_id") String recipe_id);

    @Query(value = "SELECT COUNT(*) FROM recipe_preferences WHERE user_id = :userId AND recipe_id = :recipe_id AND hidden = true", nativeQuery = true)
    long findRecipeHidden(@Param("userId") long user,
                         @Param("recipe_id") String recipe_id);

}
