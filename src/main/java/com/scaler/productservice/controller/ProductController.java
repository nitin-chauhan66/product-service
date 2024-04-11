package com.scaler.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.productservice.dto.ProductListResponseDTO;
import com.scaler.productservice.dto.ProductRequestDTO;
import com.scaler.productservice.dto.ProductResponseDTO;
import com.scaler.productservice.exception.ProductNotFoundException;
import com.scaler.productservice.service.ProductService;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<ProductListResponseDTO> getAllProducts() {
        ProductListResponseDTO response = productService.getAllProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponseDTO> getProductByID(@PathVariable("id") int id)
            throws ProductNotFoundException {
        ProductResponseDTO response = productService.geProductById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO response = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") int id) {
        Boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductResponseDTO> updateProductById(@PathVariable("id") int id,
            @RequestBody ProductRequestDTO productRequestDTO) throws ProductNotFoundException {
        ProductResponseDTO responseDTO = productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
