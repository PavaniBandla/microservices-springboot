package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.entity.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto create(ProductDto dto) {
        Product product = toEntity(dto);
        return toDto(productRepository.save(product));
    }

    public List<ProductDto> getAll() {
        return productRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public ProductDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));

        return toDto(product);
    }

    public ProductDto update(Long id, ProductDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        return toDto(productRepository.save(product));
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found: " + id);
        }
        productRepository.deleteById(id);
    }

    private ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity()
        );
    }

    private Product toEntity(ProductDto dto) {
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getQuantity()
        );
    }
}
