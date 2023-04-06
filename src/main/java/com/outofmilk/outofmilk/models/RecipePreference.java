package com.outofmilk.outofmilk.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "grocery_items")
public class RecipePreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(nullable = false, columnDefinition = "INT(100)")
    private long recipe_id;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private long favorite;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private long hidden;

    @ManyToOne
    @JoinColumn (nullable = false, name = "user_id")
    private User user;

}
