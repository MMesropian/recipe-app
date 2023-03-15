package com.mmesropian.recipeapp.repositories;

import com.mmesropian.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepositories extends CrudRepository <Category, Long> {

}
