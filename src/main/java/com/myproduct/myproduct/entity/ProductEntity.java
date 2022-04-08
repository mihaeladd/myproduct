package com.myproduct.myproduct.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Long id;

    @Column(name = "barcode")
    public String barcode;

    @Column(name = "name")
    public String name;

    @Column(name = "category")
    public String category;

    @Column(name = "brand")
    public String brand;


    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(
            name = "product_ingredient",
            joinColumns = { @JoinColumn(name = "product_id")},
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id")}
    )
    Set<IngredientEntity> ingredients = new HashSet<>();

    public Set<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }

    public ProductEntity() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ProductEntity(Long id, String barcode, String name, String category, String brand) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.category = category;
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
}
