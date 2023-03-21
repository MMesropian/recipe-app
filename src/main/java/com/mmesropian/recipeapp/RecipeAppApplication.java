package com.mmesropian.recipeapp;

import com.mmesropian.recipeapp.domain.Category;
import com.mmesropian.recipeapp.repositories.CategoryRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class RecipeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeAppApplication.class, args);
	}

}
