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
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(nullable = false)
    private String name;

//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(
//            name="pantry_items",
//            joinColumns={@JoinColumn(name="ingredient_id")},
//            inverseJoinColumns={@JoinColumn(name="pantry_item_id")}
//    )
////    @ManyToMany(mappedBy = "pantryItems")
//    private List<PantryItem> pantryItems;

}
