package me.parkdaiho.board.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.parkdaiho.board.domain.Post;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
public class PostListResponse {

    private Long id;
    private String title;
    private String nickname;
    private String createdAt;
    private Long views;

    public PostListResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.nickname = post.getUser().getNickname();
        this.createdAt = post.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.views = post.getViews();
    }
}
