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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ProductResponseDTO geProductById(int id) throws ProductNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO) {
        // TODO Auto-generated method stub
        return null;
    }

}
