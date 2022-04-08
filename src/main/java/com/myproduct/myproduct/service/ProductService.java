package com.myproduct.myproduct.service;

import com.myproduct.myproduct.dto.CreateProductRequest;
import com.myproduct.myproduct.dto.ProductResponse;
import com.myproduct.myproduct.entity.IngredientEntity;
import com.myproduct.myproduct.entity.ProductEntity;
import com.myproduct.myproduct.mapper.ProductMapper;
import com.myproduct.myproduct.repository.IngredientRepository;
import com.myproduct.myproduct.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final IngredientRepository ingredientRepository;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, IngredientRepository ingredientRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.ingredientRepository = ingredientRepository;
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (ProductEntity productEntity: productEntities){
            ProductResponse productResponse = productMapper.mapToDTO(productEntity);
            productResponses.add(productResponse);
        }
        return productResponses;
    }

    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public ProductResponse addNewProduct(CreateProductRequest createProductRequest) {
        Set<IngredientEntity> ingredientEntities = new HashSet<>();
        ProductEntity productEntity = productMapper.mapToEntity(createProductRequest);
        for (String ingredient: createProductRequest.getIngredients()){
            IngredientEntity foundIngredient = ingredientRepository.findByName(ingredient);
            if (foundIngredient != null){
                ingredientEntities.add(foundIngredient);
            } else {
                IngredientEntity ingredientEntity = new IngredientEntity();
                ingredientEntity.setName(ingredient);
                ingredientEntity = ingredientRepository.save(ingredientEntity);
                ingredientEntities.add(ingredientEntity);
            }
        }
        productEntity.setIngredients(ingredientEntities);
        ProductEntity savedProduct = productRepository.save(productEntity);
        return productMapper.mapToDTO(savedProduct);

    }


    public ProductResponse updateProduct(Long id, CreateProductRequest createProductRequest) {
        ProductEntity existingProduct = productRepository.findById(id).get();
        if (createProductRequest.getName() != null){
            existingProduct.setName(createProductRequest.getName());
        }
        if (createProductRequest.getBarcode() != null){
            existingProduct.setBarcode(createProductRequest.getBarcode());
        }
        if (createProductRequest.getBrand() != null){
            existingProduct.setBrand(createProductRequest.getBrand());
        }
        if (createProductRequest.getCategory() != null){
            existingProduct.setCategory(createProductRequest.getCategory());
        }
        ProductEntity savedProduct = productRepository.save(existingProduct);
        return productMapper.mapToDTO(savedProduct);
    }

    public void deleteProductByID(Long id) {
        productRepository.deleteById(id);
    }

    public ProductResponse getProductByBarcode(String barcode) {
        ProductEntity foundProduct = productRepository.findProductByBarcode(barcode);
        return productMapper.mapToDTO(foundProduct);
    }
}
