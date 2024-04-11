package com.scaler.productservice.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scaler.productservice.dto.FakeStoreProductRequestDTO;
import com.scaler.productservice.dto.FakeStoreProductResponseDTO;

@Service
public class FakeStoreAPIClient {
    private RestTemplateBuilder restTemplateBuilder;

    private String fakeStoreAPIURL;
    private String fakeStoreAPIPathProduct;

    @Autowired
    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder,
            @Value("${fakestore.api.url}") String fakeStoreAPIURL,
            @Value("${fakestore.api.path.product}") String fakeStoreAPIPathProduct) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIURL = fakeStoreAPIURL;
        this.fakeStoreAPIPathProduct = fakeStoreAPIPathProduct;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {
        String createProductURL = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.postForEntity(createProductURL,
                fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id) {
        String getProduct = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productResponse = restTemplate.getForEntity(getProduct,
                FakeStoreProductResponseDTO.class);
        return productResponse.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts() {
        String getAllProducts = fakeStoreAPIURL + fakeStoreAPIPathProduct;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productResponseArray = restTemplate.getForEntity(getAllProducts,
                FakeStoreProductResponseDTO[].class);
        return List.of(productResponseArray.getBody());
    }

    public void deleteProduct(int id) {
        String productDeleteURL = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(productDeleteURL);
    }

    public FakeStoreProductResponseDTO updateProduct(int id, FakeStoreProductRequestDTO fakeStoreProductRequestDTO) {
        String productUpdateURL = fakeStoreAPIURL + fakeStoreAPIPathProduct + "/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.exchange(productUpdateURL, HttpMethod.PUT,
                new HttpEntity<FakeStoreProductRequestDTO>(fakeStoreProductRequestDTO),
                FakeStoreProductResponseDTO.class).getBody();
    }
}
