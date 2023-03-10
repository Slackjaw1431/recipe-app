package com.tmportfolio.recipeapp.services;

import com.tmportfolio.recipeapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long aLong);
}