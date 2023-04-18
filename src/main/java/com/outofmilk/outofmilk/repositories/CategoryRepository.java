package com.outofmilk.outofmilk.repositories;

import com.outofmilk.outofmilk.models.Category;
import com.outofmilk.outofmilk.models.RecipePreference;
import com.outofmilk.outofmilk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByNameIn(List<String> categoryNames);
}
