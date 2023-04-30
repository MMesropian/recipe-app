package com.mmesropian.recipeapp.services;

import com.mmesropian.recipeapp.domain.Recipe;
import com.mmesropian.recipeapp.repositories.RecipeRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.processor.SpringValueTagProcessor;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepositories recipeRepositories;

    public RecipeServiceImpl(RecipeRepositories recipeRepositories) {
        this.recipeRepositories = recipeRepositories;
    }

    @Override
    public Set<Recipe> getRecipes() {

        log.debug("im in the service");
        Set<Recipe> recipeSet = new HashSet<>();
        //recipeRepositories.findAll().iterator().forEachRemaining(recipeSet::add);

        recipeRepositories.findAll().forEach(recipe -> recipeSet.add(recipe));
        /*for (Recipe recipe : recipeRepositories.findAll()) {
            recipeSet.add(recipe);
        }*/

        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {

        Optional<Recipe> recipeOptional = recipeRepositories.findById(id);

        if (!recipeOptional.isPresent()){
            throw  new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();
    }
}
