package org.luis.goes.presentation.dto.user;

import org.luis.goes.presentation.dto.DTO;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email
) implements DTO {
    public UserResponseDTO(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}