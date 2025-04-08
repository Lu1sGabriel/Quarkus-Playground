package org.luis.goes.domain.service.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.luis.goes.domain.entitite.user.UserEntity;

import java.util.List;

@ApplicationScoped
public class UserService {

    public List<UserEntity> getAll(Integer page, Integer pageSize) {
        return UserEntity.findAll().page(page, pageSize).list();
    }

    @Transactional()
    public UserEntity create(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }

}
