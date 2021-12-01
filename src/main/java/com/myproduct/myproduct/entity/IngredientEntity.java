package com.myproduct.myproduct.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ingredient")
public class IngredientEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "function")
    public String function;

    @Column(name = "irritancy")
    public Integer irritancy;

    @Column(name = "rating")
    public String rating;

    public IngredientEntity() {
    }

    public IngredientEntity(Long id, String name, String function, Integer irritancy, String rating) {
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
