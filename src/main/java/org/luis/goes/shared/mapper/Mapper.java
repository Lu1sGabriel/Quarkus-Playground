package org.luis.goes.shared.mapper;

import org.luis.goes.domain.entity.Mappable;
import org.luis.goes.presentation.dto.DTO;

import java.util.List;

public interface Mapper<RequestDTO extends DTO , ResponseDTO extends DTO, Entity extends Mappable> {

    // Entrada: DTO → Entity
    Entity toEntity(RequestDTO dto);

    // Saída: Entity → DTO
    ResponseDTO toDto(Entity entity);

    // Listas
    List<Entity> toEntityList(List<RequestDTO> dtoList);

    List<ResponseDTO> toDtoList(List<Entity> entityList);
}