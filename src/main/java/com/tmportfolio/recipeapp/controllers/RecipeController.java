package com.tmportfolio.recipeapp.controllers;

import com.tmportfolio.recipeapp.commands.RecipeCommand;
import com.tmportfolio.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipes/{id}/show/")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipes/show";
    }

    @RequestMapping("/recipes/{id}/edit/")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipes/recipeForm";
    }

    @RequestMapping("recipes/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipes/recipeForm";
    }

    @PostMapping
    @RequestMapping(name = "recipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeCommand command){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipes/show/" + savedCommand.getId();
    }

//    @RequestMapping(name="recipe/{id}/delete")
//    public String deleteRecipe(@PathVariable String id, Model model){
//        model.addAttribute("recipe", recipeService.deleteRecipeById(Long.valueOf(id)));
//        return "recipes/show";
//    }
}