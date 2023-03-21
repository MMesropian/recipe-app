package com.mmesropian.recipeapp.controllers;

import com.mmesropian.recipeapp.domain.Category;
import com.mmesropian.recipeapp.domain.UnitOfMeasure;
import com.mmesropian.recipeapp.repositories.CategoryRepositories;
import com.mmesropian.recipeapp.repositories.UnitOfMeasureRepositories;
import com.mmesropian.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
