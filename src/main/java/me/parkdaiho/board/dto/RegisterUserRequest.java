package me.parkdaiho.board.dto;

import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
public class RegisterUserRequest {

    private final String username;
    private final String password;
    private final String nickname;

    public User toEntity() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .nickname(nickname)
                .build();
    }
}
