package org.luis.goes.shared.utils;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.luis.goes.domain.entity.user.UserEntity;

import java.util.Arrays;
import java.util.HashSet;

@ApplicationScoped
public class GenerateToken {

    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String issuer;

    public String generateToken(UserEntity userEntity) {
        String token = Jwt.issuer(issuer)
                .upn(userEntity.getEmail())
                .claim("userId", userEntity.getId())
                .claim("email", userEntity.getEmail())
                .expiresAt(System.currentTimeMillis() + 3600)
                .groups(new HashSet<>(Arrays.asList("User")))
                .sign();
        return token;
    }

}