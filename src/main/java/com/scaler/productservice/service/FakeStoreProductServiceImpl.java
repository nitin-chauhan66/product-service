package com.scaler.productservice.service;

import static com.scaler.productservice.mapper.ProductMapper.fakeStoreProductResponseToProductResponseDTO;
import static com.scaler.productservice.mapper.ProductMapper.productRequestToFakeStoreProductRequestDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaler.productservice.client.FakeStoreAPIClient;
import com.scaler.productservice.dto.FakeStoreProductResponseDTO;
import com.scaler.productservice.dto.ProductListResponseDTO;
import com.scaler.productservice.dto.ProductRequestDTO;
import com.scaler.productservice.dto.ProductResponseDTO;
import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.utils.ProductUtils;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService {

    private FakeStoreAPIClient fakeStoreAPIClient;

    @Autowired
    public FakeStoreProductServiceImpl(FakeStoreAPIClient fakeStoreAPIClient) {
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProductResponseDTOs = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO responseDTO = new ProductListResponseDTO();
        for (FakeStoreProductResponseDTO fakeStoreProductResponseDTO : fakeStoreProductResponseDTOs) {
            responseDTO.getProducts().add(fakeStoreProductResponseToProductResponseDTO(fakeStoreProductResponseDTO));
        }
        return responseDTO;
    }

    @Override
    public ProductResponseDTO geProductById(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        if (ProductUtils.isNull(fakeStoreProductResponseDTO)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        return fakeStoreProductResponseToProductResponseDTO(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient
                .createProduct(productRequestToFakeStoreProductRequestDTO(productRequestDTO));
        return fakeStoreProductResponseToProductResponseDTO(fakeStoreProductResponseDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
        fakeStoreAPIClient.deleteProduct(id);
        return true;
    }

    @Override
    public ProductResponseDTO updateProduct(int id, ProductRequestDTO productRequestDTO) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.updateProduct(id,
                productRequestToFakeStoreProductRequestDTO(productRequestDTO));
                if (ProductUtils.isNull(fakeStoreProductResponseDTO)) {
                    throw new ProductNotFoundException("Product not found with id: " + id);
                }
        return fakeStoreProductResponseToProductResponseDTO(fakeStoreProductResponseDTO);
    }

}
