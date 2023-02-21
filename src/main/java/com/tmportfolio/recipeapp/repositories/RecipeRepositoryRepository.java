package com.tmportfolio.recipeapp.repositories;


import com.tmportfolio.recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepositoryRepository extends CrudRepository<Recipe, Long> {



}