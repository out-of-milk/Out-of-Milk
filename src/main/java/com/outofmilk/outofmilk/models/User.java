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
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="pantry_items",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="ingredient_id")}
    )
    private List<Ingredient> pantryItems;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="grocery_items",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="ingredient_id")}
    )
    private List<Ingredient> groceryItems;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @ToString.Exclude
    private List<RecipePreference> recipePreferences;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name="user_category",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<Category> categories;

    public User(User copy) {
        id = copy.id;
        username = copy.username;
        email = copy.email;
        password = copy.password;
    }

}
