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
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private ProductMapper productMapper;


    public List<ProductDTO> getAll(){
        return this.productRepository.findAll()
                .stream().map(productMapper::toDTO)
                .collect(Collectors.toList());

    }

    public Optional<Product> getById(final Long id){
        return this.productRepository.findById(id);
    }

    public ProductDTO saveProduct(final ProductDTO productDTO) {
        Product newAddedProduct = this.productRepository.save(productMapper.toEntity(productDTO));

        if( newAddedProduct == null) {
            return null;
        }

        return this.productMapper.toDTO(newAddedProduct);
    }
}
