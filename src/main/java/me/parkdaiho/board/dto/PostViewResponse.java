package me.parkdaiho.board.dto;

import lombok.Getter;
import me.parkdaiho.board.domain.Post;

import java.time.LocalDateTime;

@Getter
public class PostViewResponse {

    private String username;
    private String title;
    private String contents;
    private LocalDateTime createdAt;

    public PostViewResponse(Post post) {
        this.username = post.getUser().getUsername();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.createdAt = post.getCreatedAt();
    }
}
