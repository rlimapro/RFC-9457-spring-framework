package com.github.rlimapro.rfc9457.api.dto;

import java.util.UUID;

public record ProductResponse(
    UUID id,
    String name,
    String description,
    Long quantity
) {}
