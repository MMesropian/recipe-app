package com.mmesropian.recipeapp.services;

import com.mmesropian.recipeapp.commands.RecipeCommand;
import com.mmesropian.recipeapp.converters.RecipeCommandToRecipe;
import com.mmesropian.recipeapp.converters.RecipeToRecipeCommand;
import com.mmesropian.recipeapp.domain.Recipe;
import com.mmesropian.recipeapp.repositories.RecipeRepositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepositories recipeRepositories;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepositories, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    void getRecipesByIdTest() {

        Recipe recipe = new Recipe();
        HashSet recepiesData = new HashSet();
        recepiesData.add(recipe);

        when(recipeRepositories.findAll()).thenReturn(recepiesData);
        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(),1);
        verify(recipeRepositories, times(1)).findAll();
        verify(recipeRepositories, never()).findById(anyLong());
    }

    @Test
    void getRecipeCommandByIdTest() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepositories.findById(anyLong())).thenReturn(recipeOptional);

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);

        RecipeCommand recipeCommandById = recipeService.fimdCommandById(1L);

        assertNotNull( recipeCommandById,"Null recipe returned");
        verify(recipeRepositories, times(1)).findById(anyLong());
        verify(recipeRepositories, never()).findAll();
    }

    @Test
    void getRecipesById() {

        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepositories.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull(recipeReturned, "Null recipe returned");

        verify(recipeRepositories, times(1)).findById(anyLong());
        verify(recipeRepositories, never()).findAll();

    }
}