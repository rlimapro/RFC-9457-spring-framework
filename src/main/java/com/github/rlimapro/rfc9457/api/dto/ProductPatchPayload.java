package com.github.rlimapro.rfc9457.api.dto;

import java.util.Optional;

public record ProductPatchPayload(
    Optional<String> name,
    Optional<String> description
) {}
