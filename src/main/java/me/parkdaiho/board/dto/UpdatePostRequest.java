package me.parkdaiho.board.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdatePostRequest {

    private String title;
    private String contents;
}
