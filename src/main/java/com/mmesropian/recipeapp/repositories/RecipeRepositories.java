package com.mmesropian.recipeapp.repositories;

import com.mmesropian.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepositories extends CrudRepository <Recipe, Long> {
}
