package com.scaler.productservice.mapper;

import com.scaler.productservice.dto.FakeStoreProductRequestDTO;
import com.scaler.productservice.dto.FakeStoreProductResponseDTO;
import com.scaler.productservice.dto.ProductRequestDTO;
import com.scaler.productservice.dto.ProductResponseDTO;

public class ProductMapper {
    public static FakeStoreProductRequestDTO productRequestToFakeStoreProductRequestDTO(
            ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = new FakeStoreProductRequestDTO();
        fakeStoreProductRequestDTO.setTitle(productRequestDTO.getTitle());
        fakeStoreProductRequestDTO.setPrice(productRequestDTO.getPrice());
        fakeStoreProductRequestDTO.setCategory(productRequestDTO.getCategory());
        fakeStoreProductRequestDTO.setDescription(productRequestDTO.getDescription());
        fakeStoreProductRequestDTO.setImage(productRequestDTO.getImage());

        return fakeStoreProductRequestDTO;
    }

    public static ProductResponseDTO fakeStoreProductResponseToProductResponseDTO(
            FakeStoreProductResponseDTO fakeStoreProductResponseDTO) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setTitle(fakeStoreProductResponseDTO.getTitle());
        productResponseDTO.setCategory(fakeStoreProductResponseDTO.getCategory());
        productResponseDTO.setDescription(fakeStoreProductResponseDTO.getDescription());
        productResponseDTO.setId(fakeStoreProductResponseDTO.getId());
        productResponseDTO.setImage(fakeStoreProductResponseDTO.getImage());
        productResponseDTO.setPrice(fakeStoreProductResponseDTO.getPrice());
        
        return productResponseDTO;
    }
}
