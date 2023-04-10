package com.mmesropian.recipeapp.services;

import com.mmesropian.recipeapp.domain.Recipe;
import com.mmesropian.recipeapp.repositories.RecipeRepositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepositories recipeRepositories;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepositories);
    }

    @Test
    void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet recepiesData = new HashSet();
        recepiesData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recepiesData);
        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(),1);
        verify(recipeRepositories, times(1)).findAll();
    }
}