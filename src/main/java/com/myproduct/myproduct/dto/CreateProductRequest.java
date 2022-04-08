package com.myproduct.myproduct.dto;

import java.util.List;

public class CreateProductRequest {

    private Long id;
    private String barcode;
    private String name;
    private String brand;
    private String category;
    private List<String> ingredients;

    public CreateProductRequest() {
    }

    public CreateProductRequest(Long id, String barcode, String name, String producator, String category, List<String> ingredients) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.brand = producator;
        this.category = category;
        this.ingredients = ingredients;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }


}
