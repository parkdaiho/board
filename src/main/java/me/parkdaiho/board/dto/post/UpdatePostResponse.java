package me.parkdaiho.board.dto.post;

import lombok.Getter;
import lombok.Setter;
import me.parkdaiho.board.domain.Post;

@Getter
@Setter
public class UpdatePostResponse {

    private Long id;
    private String title;
    private String contents;

    public UpdatePostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
    }
}
