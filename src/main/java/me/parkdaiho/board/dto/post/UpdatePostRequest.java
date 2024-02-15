package me.parkdaiho.board.dto.post;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePostRequest {

    private String title;
    private String contents;
}
