package com.tmportfolio.recipeapp.services;

import com.tmportfolio.recipeapp.model.Recipe;
import com.tmportfolio.recipeapp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

        return recipeSet;
    }

    @Override
    public Recipe findById(Long aLong) {
        Optional<Recipe> foundRecipe = recipeRepository.findById(aLong);

        if(!foundRecipe.isPresent()){
            return null;
        }
        return foundRecipe.get();
    }
}