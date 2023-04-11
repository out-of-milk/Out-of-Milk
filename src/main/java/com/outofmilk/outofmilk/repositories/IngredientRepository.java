package com.outofmilk.outofmilk.repositories;

import com.outofmilk.outofmilk.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {



}
