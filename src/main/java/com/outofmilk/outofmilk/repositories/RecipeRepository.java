package com.outofmilk.outofmilk.repositories;

import com.outofmilk.outofmilk.models.Recipe;
import com.outofmilk.outofmilk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findByIdMeal(long id_Meal);
}
