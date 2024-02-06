package me.parkdaiho.board.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.parkdaiho.board.domain.Post;

@RequiredArgsConstructor
@Getter
@Setter
public class AddPostRequest {

    private final Long userId;
    private final String title;
    private final String contents;

    public Post toEntity() {
        return Post.builder()
                .userId(userId)
                .title(title)
                .contents(contents)
                .build();
    }
}
