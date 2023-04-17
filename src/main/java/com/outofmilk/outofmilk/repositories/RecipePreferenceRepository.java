package com.outofmilk.outofmilk.repositories;

import com.outofmilk.outofmilk.models.RecipePreference;
import com.outofmilk.outofmilk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface RecipePreferenceRepository extends JpaRepository<RecipePreference, Long> {
//    List<RecipePreference> findByUserId(long user_id);

    @Query("from RecipePreference r where r.user = ?1 and r.favorite = true")
    List<RecipePreference> findFavoritesById(User user);

    @Query("from RecipePreference r where r.user = ?1 and r.favorite = false")
    List<RecipePreference> findHiddenById(User user);

    @Modifying
    @Query(value = "delete from recipe_preferences where user_id = :recipePreferencesUserId and recipe_id = :recipePreferencesRecipeId", nativeQuery = true)
    void deleteHiddenRecipeById(@Param("recipePreferencesUserId") Long recipePreferencesUserId,
                                @Param("recipePreferencesRecipeId") Long recipePreferencesRecipeId);

}
