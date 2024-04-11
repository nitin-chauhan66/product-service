package com.scaler.productservice.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductListResponseDTO {
    private List<ProductResponseDTO> products;

    public ProductListResponseDTO() {
        this.products = new ArrayList<>();
    }

    public List<ProductResponseDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponseDTO> products) {
        this.products = products;
    }
}
