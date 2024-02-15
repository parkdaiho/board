package me.parkdaiho.board.dto.user;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
public class RegisterUserRequest {

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9]{8,16}",
            message = "알파벳 소문자, 대문자, 숫자로 이루어진 8자리 이상 16자리 이하")
    private final String username;
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[~!@#$%^&*-_+=?])[a-zA-Z0-9~!@#$%^&*_+=]{8,20}$",
            message = "알파벳 소문자, 대문자, 숫자, 특수문자를 최소한 1개 이상 포함하는 8자리 이상 20자리 이하")
    private final String password;
    @NotBlank
    @Pattern(regexp = "[a-zA-Z가-힣0-9]{4,16}",
            message = "특수문자를 포함하지 않는 4자리 이상 16자리 이하")
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
