package com.mmesropian.recipeapp.repositories;

import com.mmesropian.recipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoriesIT {


    @Autowired
    UnitOfMeasureRepositories unitOfMeasureRepositories;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByDescription() {
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepositories.findByDescription("Teaspoon");
        assertEquals("Teaspoon", unitOfMeasure.get().getDescription());
    }
    @Test
    void findByDescriptionCup() {
        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepositories.findByDescription("Cup");
        assertEquals("Cup", unitOfMeasure.get().getDescription());
    }
}