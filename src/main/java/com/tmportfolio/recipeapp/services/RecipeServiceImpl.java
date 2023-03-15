package com.tmportfolio.recipeapp.services;

import com.tmportfolio.recipeapp.commands.RecipeCommand;
import com.tmportfolio.recipeapp.converters.RecipeCommandToRecipe;
import com.tmportfolio.recipeapp.converters.RecipeToRecipeCommand;
import com.tmportfolio.recipeapp.model.Recipe;
import com.tmportfolio.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;


    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe,
                             RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
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

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);

        log.debug("Saved recipe Id: " + savedRecipe.getId());

        return recipeToRecipeCommand.convert(savedRecipe);
    }
}