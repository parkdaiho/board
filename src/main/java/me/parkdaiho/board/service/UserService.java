package me.parkdaiho.board.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.dto.RegisterUserRequest;
import me.parkdaiho.board.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User registerUser(RegisterUserRequest request) {
        return userRepository.save(request.toEntity());
    }

    public boolean logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());

        return true;
    }
}
