package com.example.orderservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ProductClient {

    private final RestClient restClient;

    public ProductClient(
            RestClient.Builder restClientBuilder,
            @Value("${product.service.url}") String productServiceUrl) {

        this.restClient = restClientBuilder
                .baseUrl(productServiceUrl)
                .build();
    }

    public void checkProductExists(Long productId) {
        restClient.get()
                .uri("/api/products/{id}", productId)
                .retrieve()
                .toBodilessEntity();
    }
}
