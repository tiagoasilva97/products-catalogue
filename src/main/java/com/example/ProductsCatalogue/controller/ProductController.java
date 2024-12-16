package com.example.ProductsCatalogue.controller;

import com.example.ProductsCatalogue.dto.ProductDTO;
import com.example.ProductsCatalogue.entity.Product;
import com.example.ProductsCatalogue.service.ProductService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> listProducts = this.productService.getAll();

        if(listProducts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable final Long id) {
        return this.productService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody final ProductDTO product) {
        ProductDTO productDTO = this.productService.saveProduct(product);

        if (productDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(productDTO);
    }
}
