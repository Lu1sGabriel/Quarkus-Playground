package org.luis.goes.application.mapper.user;

import jakarta.enterprise.context.ApplicationScoped;
import org.luis.goes.application.mapper.Mapper;
import org.luis.goes.domain.entity.user.UserEntity;
import org.luis.goes.infrastructure.presentation.dto.user.UserRequestDTO;
import org.luis.goes.infrastructure.presentation.dto.user.UserResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UserMapper implements Mapper<UserRequestDTO, UserResponseDTO, UserEntity> {

    @Override
    public UserEntity toEntity(UserRequestDTO dto) {
        var entity = new UserEntity();
        entity.setName(dto.name());
        return entity;
    }

    @Override
    public UserResponseDTO toDto(UserEntity entity) {
        return new UserResponseDTO(
                entity.getId(),
                entity.getName()
        );
    }

    @Override
    public List<UserEntity> toEntityList(List<UserRequestDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<UserResponseDTO> toDtoList(List<UserEntity> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

}