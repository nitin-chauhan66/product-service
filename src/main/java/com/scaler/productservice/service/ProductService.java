package com.scaler.productservice.service;

import com.scaler.productservice.dto.ProductListResponseDTO;
import com.scaler.productservice.dto.ProductRequestDTO;
import com.scaler.productservice.dto.ProductResponseDTO;
import com.scaler.productservice.exception.ProductNotFoundException;

public interface ProductService {
    ProductListResponseDTO getAllProducts();

    ProductResponseDTO geProductById(int id) throws ProductNotFoundException;

    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    boolean deleteProduct(int id);

    ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO) throws ProductNotFoundException;
}
