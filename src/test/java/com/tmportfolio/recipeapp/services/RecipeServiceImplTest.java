package com.tmportfolio.recipeapp.services;

import com.tmportfolio.recipeapp.model.Recipe;
import com.tmportfolio.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    void getRecipes() {
        Recipe  recipe  = new Recipe();
        HashSet recipes = new HashSet();
        recipes.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipes);//when recipeRepo.finalAll is called then return recipes

        Set<Recipe> recipeSet = recipeService.getRecipes();

        assertEquals(1, recipeSet.size());
        verify(recipeRepository, Mockito.times(1)).findAll();
    }
}