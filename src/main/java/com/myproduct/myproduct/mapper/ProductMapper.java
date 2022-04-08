package com.myproduct.myproduct.mapper;

import com.myproduct.myproduct.dto.CreateProductRequest;
import com.myproduct.myproduct.dto.IngredientDTO;
import com.myproduct.myproduct.dto.ProductResponse;
import com.myproduct.myproduct.entity.IngredientEntity;
import com.myproduct.myproduct.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    private final IngredientMapper ingredientMapper;

    public ProductMapper(IngredientMapper ingredientMapper) {
        this.ingredientMapper = ingredientMapper;
    }

    public ProductEntity mapToEntity(CreateProductRequest createProductRequest) {
        return new ProductEntity(null, createProductRequest.getBarcode(), createProductRequest.getName(), createProductRequest.getCategory(), createProductRequest.getBrand());
    }

    public ProductResponse mapToDTO(ProductEntity savedProduct) {
        Set<IngredientEntity> ingredients = savedProduct.getIngredients();
        List<IngredientDTO> ingredientDTOList = new ArrayList<>();
        for (IngredientEntity ingredient : ingredients) {
            IngredientDTO ingredientDTO = ingredientMapper.mapToDTO(ingredient);
            ingredientDTOList.add(ingredientDTO);
        }

        //aceeasi metoda de a adauga ingredientele(entitati) intr-o lista de DTOs (incepand cu linia 29)
//        List<IngredientDTO> ingredientDTOS = savedProduct.getIngredients().stream()
//                .map(ingredientMapper::mapToDTO)
//                .collect(Collectors.toList());


        return new ProductResponse(savedProduct.getId(),
                savedProduct.getBarcode(),
                savedProduct.getName(),
                savedProduct.getBrand(),
                savedProduct.getCategory(),
                ingredientDTOList);
    }
}
