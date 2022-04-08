package com.myproduct.myproduct.dto;

import javax.persistence.Column;

public class IngredientDTO {
    private Long id;
    private String name;
    private String function;
    private Integer irritancy;
    private String rating;

    public IngredientDTO() {
    }

    public IngredientDTO(Long id, String name, String function, Integer irritancy, String rating) {
        this.id = id;
        this.name = name;
        this.function = function;
        this.irritancy = irritancy;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Integer getIrritancy() {
        return irritancy;
    }

    public void setIrritancy(Integer irritancy) {
        this.irritancy = irritancy;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
