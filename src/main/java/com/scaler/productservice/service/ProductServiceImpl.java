package com.scaler.productservice.service;

import org.springframework.stereotype.Service;

import com.scaler.productservice.dto.ProductListResponseDTO;
import com.scaler.productservice.dto.ProductRequestDTO;
import com.scaler.productservice.dto.ProductResponseDTO;
import com.scaler.productservice.exception.ProductNotFoundException;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public ProductResponseDTO geProductById(int id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO) {
        return null;
    }

}
