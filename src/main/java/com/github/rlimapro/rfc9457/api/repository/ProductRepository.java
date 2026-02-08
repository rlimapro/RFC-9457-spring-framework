package com.github.rlimapro.rfc9457.api.repository;

import com.github.rlimapro.rfc9457.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
