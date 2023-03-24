package com.tmportfolio.recipeapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String  description;
    private String  source;
    private String  url;
    @Lob
    private String  directions;
    private Integer prepTime;
    private Integer cookTime;
    private Integer serving;
    @Lob
    private Byte[]  image;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")//this is bidirectional, recipe owns ingredient
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany//this is bidirectional so have to join the 2 tables, name dictates the nameof the new joined table, i think first column is from one of the original tables to keep then the other is from the 2nd table to keep
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name="category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)//cascade makes recipe owner of note one to one, if you delete recipe you delete the associated note
    @JoinColumn(name = "notes_id")
    private Notes notes;

    public Recipe() {
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);

        return this;
    }
}