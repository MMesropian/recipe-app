package com.mmesropian.recipeapp.services;

import com.mmesropian.recipeapp.commands.RecipeCommand;
import com.mmesropian.recipeapp.converters.RecipeCommandToRecipe;
import com.mmesropian.recipeapp.converters.RecipeToRecipeCommand;
import com.mmesropian.recipeapp.domain.Recipe;
import com.mmesropian.recipeapp.repositories.RecipeRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepositories recipeRepositories;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepositories recipeRepositories,
                             RecipeCommandToRecipe recipeCommandToRecipe,
                             RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepositories = recipeRepositories;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
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

    @Override
    @Transactional
    public RecipeCommand fimdCommandById(Long id) {
        return recipeToRecipeCommand.convert(findById(id));
    }

    @Transactional
    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detacheRecipe = recipeCommandToRecipe.convert(command);
        Recipe saveRecipe = recipeRepositories.save(detacheRecipe);
        log.debug("Save RecipeId: " + saveRecipe.getId());

        return recipeToRecipeCommand.convert(saveRecipe);
    }
}
