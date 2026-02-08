package com.github.rlimapro.rfc9457.api.mapper;

import com.github.rlimapro.rfc9457.api.dto.ProductCreatePayload;
import com.github.rlimapro.rfc9457.api.dto.ProductResponse;
import com.github.rlimapro.rfc9457.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse toResponse(Product product);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Product toEntity(ProductCreatePayload productPayload);

    default String map(Optional<String> description) {
        return description.orElse(null);
    }
}
