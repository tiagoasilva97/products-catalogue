package com.example.ProductsCatalogue.service;

import com.example.ProductsCatalogue.dto.ProductDTO;
import com.example.ProductsCatalogue.entity.Product;
import com.example.ProductsCatalogue.mapper.ProductMapper;
import com.example.ProductsCatalogue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductMapper productMapper;


    public List<ProductDTO> getAll(){
        List<Product> listProducts = this.productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        for(Product product: listProducts){
            productDTOS.add(productMapper.toDTO(product));
        }

        return productDTOS;

    }

    public Optional<Product> getById(final Long id){
        return this.productRepository.findById(id);
    }
}
