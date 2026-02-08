package com.github.rlimapro.rfc9457.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

public record ProductCreatePayload(
    @NotBlank(message = "Nome é obrigatório")
    String name,

    Optional <String> description,

    @Min(value = 0, message = "A quantidade mínima deve ser 0")
    @NotNull(message = "Quantidade é obrigatória")
    Long quantity
) {}
