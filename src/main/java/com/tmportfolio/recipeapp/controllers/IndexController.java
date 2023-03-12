package com.tmportfolio.recipeapp.controllers;

import com.tmportfolio.recipeapp.model.Category;
import com.tmportfolio.recipeapp.model.UnitOfMeasure;
import com.tmportfolio.recipeapp.repositories.CategoryRepository;
import com.tmportfolio.recipeapp.repositories.UnitOfMeasureRepository;
import com.tmportfolio.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "index", "/index"})
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

    @RequestMapping("/find")
    public String find(){
//        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        return "find";
    }

    @RequestMapping("/show")
    public String viewRecipeById(){
        return "show";
    }
}