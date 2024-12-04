package com.example.ProductsCatalogue.controller;

import com.example.ProductsCatalogue.dto.ProductDTO;
import com.example.ProductsCatalogue.entity.Product;
import com.example.ProductsCatalogue.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return this.productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@RequestParam final Long id) {
        return this.productService.getById(id);
    }
}
