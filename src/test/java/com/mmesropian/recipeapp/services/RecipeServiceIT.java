package com.mmesropian.recipeapp.services;

import com.mmesropian.recipeapp.commands.RecipeCommand;
import com.mmesropian.recipeapp.converters.RecipeCommandToRecipe;
import com.mmesropian.recipeapp.converters.RecipeToRecipeCommand;
import com.mmesropian.recipeapp.domain.Recipe;
import com.mmesropian.recipeapp.repositories.RecipeRepositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecipeServiceIT {

    public static final String NEW_DESCRIPTON = "New Description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepositories recipeRepositories;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;


    @Transactional
    @Test
    void testSaveDescription() {
        // given
        Iterable<Recipe> recipes = recipeRepositories.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        // when
        testRecipeCommand.setDescription(NEW_DESCRIPTON);
        RecipeCommand saveRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

        // then
        assertEquals(NEW_DESCRIPTON, saveRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(), testRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(), testRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), testRecipeCommand.getIngredients().size());
    }

}