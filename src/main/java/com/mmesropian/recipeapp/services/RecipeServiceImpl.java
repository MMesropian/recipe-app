package com.mmesropian.recipeapp.services;

import com.mmesropian.recipeapp.domain.Recipe;
import com.mmesropian.recipeapp.repositories.RecipeRepositories;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.processor.SpringValueTagProcessor;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepositories recipeRepositories;

    public RecipeServiceImpl(RecipeRepositories recipeRepositories) {
        this.recipeRepositories = recipeRepositories;
    }

    @Override
    public Set<Recipe> getRecipes() {

        Set<Recipe> recipeSet = new HashSet<>();
        //recipeRepositories.findAll().iterator().forEachRemaining(recipeSet::add);

        recipeRepositories.findAll().forEach(recipe -> recipeSet.add(recipe));
        /*for (Recipe recipe : recipeRepositories.findAll()) {
            recipeSet.add(recipe);
        }*/

        return recipeSet;
    }
}
