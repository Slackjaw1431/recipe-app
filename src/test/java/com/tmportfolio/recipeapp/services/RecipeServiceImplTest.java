package com.tmportfolio.recipeapp.services;

import com.tmportfolio.recipeapp.model.Recipe;
import com.tmportfolio.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

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

    @Test
    void getRecipesById() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        Recipe foundRecipe = recipeService.findById(1L);

        assertNotNull("Null recipe", foundRecipe);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}