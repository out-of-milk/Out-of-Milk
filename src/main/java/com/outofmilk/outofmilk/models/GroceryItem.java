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
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(nullable = false, columnDefinition = "INT(10) UNSIGNED")
    private String ingredient_id;

    @ManyToOne
    @JoinColumn (nullable = false, name = "user_id")
    private User user;

}
