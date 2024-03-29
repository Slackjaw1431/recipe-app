package com.tmportfolio.recipeapp.controllers;

import com.tmportfolio.recipeapp.commands.RecipeCommand;
import com.tmportfolio.recipeapp.exceptions.NotFoundException;
import com.tmportfolio.recipeapp.services.RecipeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private static final String RECIPE_RECIPEFORM_URL = "recipe/recipeForm";

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/show/")
    public String showById(@PathVariable String id, Model model){
            model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
            return "recipe/show";
    }

    @RequestMapping("/recipe/{id}/edit/")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeForm";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeForm";
    }

    @PostMapping("/recipe/")
    public String saveOrUpdateRecipe(@Valid @ModelAttribute("recipe") RecipeCommand command, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(objectError -> {
                log.debug(objectError.toString());
            });
            return RECIPE_RECIPEFORM_URL;
        }
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + savedCommand.getId() + "/show/";
    }

    @GetMapping
    @RequestMapping("/recipe/{id}/delete/")
    public String deleteRecipeById(@PathVariable String id){
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleNotFound(Exception e){
        log.error("Handling not found exception");
        log.error(e.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404error");
        modelAndView.addObject("exception", e);
        e.getMessage();

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView invalidIDFormat(Exception e){
        log.error("invalidIDFormat exception");
        log.error(e.getMessage());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("400error");
        modelAndView.addObject("exception", e);
        e.getMessage();

        return modelAndView;
    }

}