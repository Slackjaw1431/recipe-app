package com.tmportfolio.recipeapp.model;

import com.tmportfolio.recipeapp.repositories.RecipeRepository;
import com.tmportfolio.recipeapp.services.RecipeServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        category.setId(4l);
        assertEquals(4l, category.getId(),"Id not successfully set");
    }

    @Test
    void getDescription() {
        category.setDescription("Desc");
        assertEquals("Desc", category.getDescription().toString());
    }

}