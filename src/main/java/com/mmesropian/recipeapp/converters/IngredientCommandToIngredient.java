package com.mmesropian.recipeapp.converters;

import com.mmesropian.recipeapp.commands.IngredientCommand;
import com.mmesropian.recipeapp.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient  implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(uomConverter.convert(source.getUnitOfMeasure()));
        return ingredient;
    }
}
