package com.myproduct.myproduct.mapper;

import com.myproduct.myproduct.dto.IngredientDTO;
import com.myproduct.myproduct.entity.IngredientEntity;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {
    public IngredientEntity mapIngredientToEntity(IngredientDTO ingredientDTO) {
        return new IngredientEntity();
    }

    public IngredientDTO mapToDTO(IngredientEntity ingredientEntity) {
        return new IngredientDTO(ingredientEntity.getId(), ingredientEntity.getName(), ingredientEntity.getFunction(), ingredientEntity.getIrritancy(), ingredientEntity.getRating());
    }
}
