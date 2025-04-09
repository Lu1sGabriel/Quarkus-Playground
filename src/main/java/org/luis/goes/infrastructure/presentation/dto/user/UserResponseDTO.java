package org.luis.goes.infrastructure.presentation.dto.user;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name
) {
    public UserResponseDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
