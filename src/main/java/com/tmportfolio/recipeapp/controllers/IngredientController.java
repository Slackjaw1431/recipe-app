package com.tmportfolio.recipeapp.controllers;

import com.tmportfolio.recipeapp.services.IngredientService;
import com.tmportfolio.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/ingredients/")
    public String getIngredientList(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "/recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeId}/ingredient/{id}/show")
    public String showIngredient(@PathVariable String id, @PathVariable String recipeId, Model model){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId),Long.valueOf(id)));
        return "/recipe/ingredient/show";
    }

//    @GetMapping
//    @RequestMapping("/recipe/{id}/ingredients/")
//    public String deleteIngredient(@PathVariable String id, Model model){
//        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
//        return "/recipe/ingredient/list";
//    }

//    @GetMapping
//    @RequestMapping("/recipe/{id}/ingredients/")
//    public String getIngredientList(@PathVariable String id, Model model){
//        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
//        return "/recipe/ingredient/list";
//    }

}