package org.luis.goes.domain.service.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.luis.goes.domain.entity.user.UserEntity;
import org.luis.goes.domain.exception.ApiException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public UserEntity getById(UUID id) {
        return UserEntity.<UserEntity>findByIdOptional(id).orElseThrow(() -> new ApiException.NotFound("User not found. "));
    }

    public List<UserEntity> getAll(Integer page, Integer pageSize) {
        return UserEntity.findAll().page(page, pageSize).list();
    }

    @Transactional()
    public UserEntity create(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }

    @Transactional
    public UserEntity updateUser(UUID id, UserEntity userEntity) {
        var user = getById(id);

        user.name = userEntity.name;

        UserEntity.persist(user);

        return user;
    }

}