package com.mmesropian.recipeapp.services;

import com.mmesropian.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
