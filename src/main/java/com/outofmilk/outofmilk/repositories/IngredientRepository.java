package com.outofmilk.outofmilk.repositories;

import com.outofmilk.outofmilk.models.Ingredient;
import com.outofmilk.outofmilk.models.RecipePreference;
import com.outofmilk.outofmilk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findById(long id);

    Ingredient findByName(String name);


}
