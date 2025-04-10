package org.luis.goes.presentation.dto.user;

import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email
) {
    public UserResponseDTO(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
