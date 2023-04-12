package com.outofmilk.outofmilk.repositories;

import com.outofmilk.outofmilk.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.username = ?1")
    User findByUsername(String username);

    @Query("from User u where u.email = ?1")
    User findByEmail(String email);

    @Modifying
    @Query(value = "delete from pantry_items where id = :pantryItemId", nativeQuery = true)
    void deletePantryIngredientById(@Param("pantryItemId") Long pantryItemId);

    @Modifying
    @Query(value = "delete from pantry_items where user_id = :pantryUserId and ingredient_id = :pantryItemId", nativeQuery = true)
    void deleteIngredientById(@Param("pantryUserId") Long pantryUserId,
                              @Param("pantryItemId") Long pantryItemId);

}
