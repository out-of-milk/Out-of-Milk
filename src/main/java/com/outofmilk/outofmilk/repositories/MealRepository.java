package com.outofmilk.outofmilk.repositories;

import com.outofmilk.outofmilk.models.Meal;
import com.outofmilk.outofmilk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
    Meal findById(String idMeal);

}
