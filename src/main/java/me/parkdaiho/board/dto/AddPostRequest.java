package me.parkdaiho.board.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.parkdaiho.board.domain.Post;
import me.parkdaiho.board.domain.user.User;

@RequiredArgsConstructor
@Getter
@Setter
public class AddPostRequest {

    private final String title;
    private final String contents;

    public Post toEntity(User user) {
        return Post.builder()
                .user(user)
                .title(this.title)
                .contents(this.contents)
                .build();
    }
}
