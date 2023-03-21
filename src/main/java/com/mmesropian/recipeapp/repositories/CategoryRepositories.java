package com.mmesropian.recipeapp.repositories;

import com.mmesropian.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepositories extends CrudRepository <Category, Long> {

    Optional<Category> findByDescription(String description);

}
