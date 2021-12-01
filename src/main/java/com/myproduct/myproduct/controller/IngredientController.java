package com.myproduct.myproduct.controller;

import com.myproduct.myproduct.entity.IngredientEntity;
import com.myproduct.myproduct.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @GetMapping("/ingredients")
    public List<IngredientEntity> getAllIngredients(){
       return ingredientService.getAllIngredients();
    }

    @GetMapping("/ingredients/{id}")
    public IngredientEntity getIngredient(@PathVariable Long id){
        return ingredientService.getIngredientById(id);
    }

    @PostMapping("/ingredients")
    public void  addIngredient(@RequestBody IngredientEntity ingredientEntity){
        ingredientService.addNewIngredient(ingredientEntity);
    }

    @PutMapping("/ingredients/{id}")
    public IngredientEntity updateIngredient(@RequestBody IngredientEntity ingredientEntity, @PathVariable Long id){
        return ingredientService.updateIngredient(id, ingredientEntity);
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteIngredient(@PathVariable Long id){
        ingredientService.deleteIngredientByID(id);
    }


}
