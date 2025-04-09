package org.luis.goes.domain.service.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.luis.goes.domain.entity.user.UserEntity;
import org.luis.goes.domain.exception.ApiException;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {

    public UserEntity findById(UUID id) {
        return UserEntity.<UserEntity>findByIdOptional(id).orElseThrow(() -> new ApiException.NotFound("User not found. "));
    }

    public List<UserEntity> findAll(Integer page, Integer pageSize) {
        return UserEntity.findAll().page(page, pageSize).list();
    }

    @Transactional()
    public UserEntity create(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }

    @Transactional
    public UserEntity update(UUID id, UserEntity userEntity) {
        var user = findById(id);

        user.name = userEntity.name;

        UserEntity.persist(user);

        return user;
    }

    @Transactional
    public void delete(UUID id) {
        var user = findById(id);
        UserEntity.deleteById(user.id);
    }

}