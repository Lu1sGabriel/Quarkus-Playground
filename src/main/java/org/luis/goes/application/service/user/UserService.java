package org.luis.goes.application.service.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.luis.goes.application.mapper.user.UserMapper;
import org.luis.goes.domain.entity.user.UserEntity;
import org.luis.goes.domain.exception.ApiException;
import org.luis.goes.infrastructure.presentation.dto.user.UserRequestDTO;
import org.luis.goes.infrastructure.presentation.dto.user.UserResponseDTO;
import org.luis.goes.infrastructure.repository.user.UserRepository;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO findById(UUID id) {
        var user = userRepository.findByIdOptional(id).orElseThrow(() -> new ApiException.NotFound("User not found."));
        return userMapper.toDto(user);
    }

    public List<UserResponseDTO> findAll(Integer page, Integer pageSize) {
        var users = userRepository.findAll().page(page, pageSize).list();
        return userMapper.toDtoList(users);
    }

    @Transactional
    public UserResponseDTO create(UserRequestDTO userRequestDTO) {
        var userEntity = userMapper.toEntity(userRequestDTO);
        userRepository.persist(userEntity);
        return userMapper.toDto(userEntity);
    }

    @Transactional
    public UserResponseDTO update(UUID id, UserRequestDTO userRequestDTO) {
        var user = findEntityById(id);
        user.setName(userRequestDTO.name());
        return userMapper.toDto(user);
    }

    @Transactional
    public void delete(UUID id) {
        var user = findById(id);
        userRepository.deleteById(user.id());
    }

    private UserEntity findEntityById(UUID id) {
        return userRepository.findById(id);
    }

}