package com.tmportfolio.recipeapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

//lombak refactoring
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")//categories is the one mapping this relationship
    private Set<Recipe> recipes;

    public Category() {
    }

}