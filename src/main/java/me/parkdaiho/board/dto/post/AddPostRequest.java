package me.parkdaiho.board.dto.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.parkdaiho.board.domain.Post;
import me.parkdaiho.board.domain.user.User;

@Getter
@Setter
public class AddPostRequest {

    private String title;
    private String contents;

    public Post toEntity(User user) {
        return Post.builder()
                .user(user)
                .title(this.title)
                .contents(this.contents)
                .build();
    }
}
