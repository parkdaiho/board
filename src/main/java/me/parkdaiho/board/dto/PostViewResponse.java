package me.parkdaiho.board.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class PostViewResponse {

    private final Long userId;
    private final String title;
    private final String contents;
}
