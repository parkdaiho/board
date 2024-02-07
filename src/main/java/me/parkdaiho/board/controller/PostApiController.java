package me.parkdaiho.board.controller;

import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.dto.AddPostRequest;
import me.parkdaiho.board.dto.UpdatePostRequest;
import me.parkdaiho.board.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@Controller
public class PostApiController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity<Long> addPost(@AuthenticationPrincipal User user, @RequestBody AddPostRequest dto) {
        Long savedPostId = postService.addPost(dto, user);

        return ResponseEntity.created(URI.create("/posts/" + savedPostId)).build();
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<Long> updatePost(@PathVariable Long id, @RequestBody UpdatePostRequest dto) {
        Long updatedPostId = postService.updatePostById(id, dto);

        return ResponseEntity.created(URI.create("/posts/" + updatedPostId))
                .build();
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
