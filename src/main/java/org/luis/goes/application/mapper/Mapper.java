package org.luis.goes.application.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<RequestDTO, ResponseDTO, Entity> {

    // Entrada: DTO → Entity
    Entity toEntity(RequestDTO dto);

    // Saída: Entity → DTO
    ResponseDTO toDto(Entity entity);

    // Listas
    List<Entity> toEntityList(List<RequestDTO> dtoList);

    List<ResponseDTO> toDtoList(List<Entity> entityList);
}