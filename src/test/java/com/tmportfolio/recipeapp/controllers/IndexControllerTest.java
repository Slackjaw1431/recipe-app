package com.tmportfolio.recipeapp.controllers;

import com.tmportfolio.recipeapp.services.RecipeService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;

class IndexControllerTest {

    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController indexController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipeService);

    }

    @Test
    void getIndexPage() {
        assertEquals("index", indexController.getIndexPage(model));
        Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
        Mockito.verify(model, Mockito.times(1)).addAttribute(eq("recipes"), anySet());

    }

    @Test
    void find() {
        assertEquals("find", indexController.find().toString());
    }
}