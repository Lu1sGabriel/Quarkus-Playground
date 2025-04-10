package org.luis.goes.infrastructure.auth.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.luis.goes.infrastructure.repository.user.UserRepository;
import org.luis.goes.presentation.exception.ApiException;
import org.luis.goes.shared.utils.GenerateToken;

@ApplicationScoped
public class LoginService {

    @Inject
    GenerateToken generateToken;

    @Inject
    UserRepository userRepository;

    public String login(String email) {
        var user = userRepository.findByEmail(email).orElseThrow(() -> new ApiException.NotFound("User not found."));
        return generateToken.generateToken(user);
    }

}