package com.mmesropian.recipeapp.services;

import com.mmesropian.recipeapp.commands.RecipeCommand;
import com.mmesropian.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
