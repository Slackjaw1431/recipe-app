package com.tmportfolio.recipeapp.repositories;

import com.tmportfolio.recipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}