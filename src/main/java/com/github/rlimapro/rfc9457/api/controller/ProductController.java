package com.github.rlimapro.rfc9457.api.controller;

import com.github.rlimapro.rfc9457.api.dto.ProductCreatePayload;
import com.github.rlimapro.rfc9457.api.dto.ProductPatchPayload;
import com.github.rlimapro.rfc9457.api.dto.ProductResponse;
import com.github.rlimapro.rfc9457.api.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductCreatePayload payload) {
        ProductResponse response = productService.createProduct(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchProduct(@PathVariable UUID id, @Valid @RequestBody ProductPatchPayload payload) {
        ProductResponse response = productService.updateProduct(id, payload);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable UUID id) {
        ProductResponse response = productService.getProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
