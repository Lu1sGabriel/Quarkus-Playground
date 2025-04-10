package org.luis.goes.presentation.dto.user;

public record UserRequestDTO(
        String name,
        String email,
        String password
) {
}
