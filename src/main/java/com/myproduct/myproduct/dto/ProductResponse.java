package com.myproduct.myproduct.dto;

import java.util.List;

public class ProductResponse {
    private Long id;
    private String barcode;
    private String name;
    private String brand;
    private String category;
    private List<IngredientDTO> ingredients;

    public ProductResponse() {
    }

    public ProductResponse(Long id, String barcode, String name, String brand, String category, List<IngredientDTO> ingredients) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
