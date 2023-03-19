package com.tmportfolio.recipeapp.services;

import com.tmportfolio.recipeapp.commands.RecipeCommand;
import com.tmportfolio.recipeapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long aLong);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    void deleteById(Long valueOf);
    RecipeCommand findCommandById(Long valueOf);
}