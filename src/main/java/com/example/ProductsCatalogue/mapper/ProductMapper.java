package com.example.ProductsCatalogue.mapper;

import com.example.ProductsCatalogue.dto.ProductDTO;
import com.example.ProductsCatalogue.entity.Product;

public class ProductMapper {

    public ProductDTO toDTO(Product product){
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());

        return productDTO;
    }
}
