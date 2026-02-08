package com.github.rlimapro.rfc9457.api.service;

import com.github.rlimapro.rfc9457.api.dto.ProductCreatePayload;
import com.github.rlimapro.rfc9457.api.dto.ProductPatchPayload;
import com.github.rlimapro.rfc9457.api.dto.ProductResponse;
import com.github.rlimapro.rfc9457.api.exception.ProductNotFoundException;
import com.github.rlimapro.rfc9457.api.mapper.ProductMapper;
import com.github.rlimapro.rfc9457.api.repository.ProductRepository;
import com.github.rlimapro.rfc9457.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse createProduct(ProductCreatePayload payload) {
        Product product = productMapper.toEntity(payload);
        return productMapper.toResponse(productRepository.save(product));
    }

    public ProductResponse updateProduct(UUID id, ProductPatchPayload payload) {
        Product product = productRepository.findById(id)
            .orElseThrow(RuntimeException::new);

        payload.name().ifPresent(product::setName);
        payload.description().ifPresent(product::setDescription);

        return productMapper.toResponse(productRepository.save(product));
    }

    public void deleteProduct(UUID id) {
        if(!productRepository.existsById(id)) {
            throw new ProductNotFoundException("O produto com id " + id + " não foi encontrado.");
        }
        productRepository.deleteById(id);
    }

    public ProductResponse getProduct(UUID id) {
        return productMapper.toResponse(
            productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("O produto com id " + id + " não foi encontrado."))
        );
    }
}
