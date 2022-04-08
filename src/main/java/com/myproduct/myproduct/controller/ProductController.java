package com.myproduct.myproduct.controller;

import com.myproduct.myproduct.dto.CreateProductRequest;
import com.myproduct.myproduct.dto.ProductResponse;
import com.myproduct.myproduct.entity.ProductEntity;
import com.myproduct.myproduct.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductEntity getProduct(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public ProductResponse addProduct(@RequestBody CreateProductRequest createProductRequest){
       return productService.addNewProduct(createProductRequest);
    }

    @PutMapping("/products/{id}")
    public ProductResponse updateProduct(@RequestBody CreateProductRequest createProductRequest, @PathVariable Long id){
        return productService.updateProduct(id, createProductRequest);
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductByID(id);
    }

    @GetMapping("/product/barcode/{barcode}")
    public ProductResponse getProductByBarcode(@PathVariable String barcode){
        return productService.getProductByBarcode(barcode);
    }
}
