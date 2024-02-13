package me.parkdaiho.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.parkdaiho.board.domain.Post;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostListResponse {

    private Long id;
    private String title;
    private String nickname;
    private LocalDateTime createdAt;
    private Long views;

    public PostListResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.nickname = post.getUser().getNickname();
        this.createdAt = post.getCreatedAt();
        this.views = post.getViews();
    }
}
