package com.outofmilk.outofmilk.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(nullable = false, columnDefinition = "INT(100)")
    private long idMeal;

    @Column(nullable = false)
    private String strMeal;

    @Column(nullable = false)
    private String strCategory;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String strMealThumb;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    @ToString.Exclude
    private List<RecipePreference> recipePreferences;

}
