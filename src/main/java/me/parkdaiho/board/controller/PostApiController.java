package me.parkdaiho.board.controller;

import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.dto.AddPostRequest;
import me.parkdaiho.board.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class PostApiController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<Long> addPost(@RequestBody AddPostRequest dto) {
        Long savedPostId = postService.addPost(dto);

        return ResponseEntity.ok()
                .body(savedPostId);
    }
}
