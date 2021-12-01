package com.myproduct.myproduct.service;

import com.myproduct.myproduct.entity.IngredientEntity;
import com.myproduct.myproduct.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    public List<IngredientEntity> getAllIngredients() {
        return ingredientRepository.findAll();
    }


    public IngredientEntity getIngredientById(Long id) {
        return ingredientRepository.findById(id).get();
    }

    public void addNewIngredient(IngredientEntity ingredientEntity) {
        ingredientRepository.save(ingredientEntity);
    }


    public IngredientEntity updateIngredient(Long id, IngredientEntity ingredientEntity) {
        IngredientEntity existingIngredient = ingredientRepository.findById(id).get();
        if (ingredientEntity.getName() != null){
            existingIngredient.setName(ingredientEntity.getName());
        }
        if (ingredientEntity.getFunction() != null) {
            existingIngredient.setFunction(ingredientEntity.getFunction());
        }
        if (ingredientEntity.getIrritancy() != null) {
            existingIngredient.setIrritancy(ingredientEntity.getIrritancy());
        }
        if (ingredientEntity.getRating() != null) {
            existingIngredient.setRating(ingredientEntity.getRating());
        }
        return ingredientRepository.save(existingIngredient);
    }

    public void deleteIngredientByID(Long id) {
        ingredientRepository.deleteById(id);
    }
}

