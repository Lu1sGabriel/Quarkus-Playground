package org.luis.goes.presentation.dto.user;

import org.luis.goes.presentation.dto.DTO;

public record UserRequestDTO(
        String name,
        String email,
        String password
) implements DTO {
}
