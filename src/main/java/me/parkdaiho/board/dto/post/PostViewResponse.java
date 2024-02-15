package me.parkdaiho.board.dto.post;

import lombok.Getter;
import me.parkdaiho.board.domain.Post;
import me.parkdaiho.board.domain.user.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class PostViewResponse {

    private Long id;
    private String writer;
    private String title;
    private String contents;
    private String createdAt;
    private Long views;
    private Boolean isWriter;

    public PostViewResponse(Post post, User user) {
        this.id = post.getId();
        this.writer = post.getUser().getNickname();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.createdAt = post.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.views = post.getViews();
        this.isWriter = post.getUser().getId() == user.getId();
    }
}
