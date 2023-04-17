package com.outofmilk.outofmilk.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "recipe_preferences")
public class RecipePreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean favorite;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean hidden;

    @ManyToOne
    @JoinColumn (nullable = false, name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn (nullable = false, name = "recipe_id", referencedColumnName = "idMeal")
    private Recipe recipe;

}
