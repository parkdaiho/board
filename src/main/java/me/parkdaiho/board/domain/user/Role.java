package me.parkdaiho.board.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {

    ADMIN("admin"), MANGER("manager"), USER("user");

    private final String role;
}
