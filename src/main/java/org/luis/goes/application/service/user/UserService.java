package org.luis.goes.application.service.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.luis.goes.domain.entity.user.UserEntity;
import org.luis.goes.domain.exception.ApiException;
import org.luis.goes.infrastructure.repository.user.UserRepository;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findById(UUID id) {
        return userRepository.findByIdOptional(id).orElseThrow(() -> new ApiException.NotFound("User not found."));
    }

    public List<UserEntity> findAll(Integer page, Integer pageSize) {
        return userRepository.findAll().page(page, pageSize).list();
    }

    @Transactional()
    public UserEntity create(UserEntity userEntity) {
        userRepository.persist(userEntity);
        return userEntity;
    }

    @Transactional
    public UserEntity update(UUID id, UserEntity userEntity) {
        var user = findById(id);

        user.setName(userEntity.getName());

        userRepository.persist(user);

        return user;
    }

    @Transactional
    public void delete(UUID id) {
        var user = findById(id);
        userRepository.deleteById(user.getId());
    }

}