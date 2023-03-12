package com.tmportfolio.recipeapp.controllers;

import com.tmportfolio.recipeapp.services.RecipeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/show/{id}")
    public String viewRecipeById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

        return "show";
    }

    @RequestMapping("/show")
    public String viewRecipeById(){
        return "show";
    }
}