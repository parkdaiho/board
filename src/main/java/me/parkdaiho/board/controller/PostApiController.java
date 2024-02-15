package me.parkdaiho.board.controller;

import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.dto.post.AddPostRequest;
import me.parkdaiho.board.dto.post.UpdatePostRequest;
import me.parkdaiho.board.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @GetMapping("/api/addTest")
    public void addTest(@AuthenticationPrincipal User user) {
        postService.add27Posts(user);
    }

    @PostMapping("/api/post")
    public ResponseEntity<?> addPost(@AuthenticationPrincipal User user,
                                        @RequestBody AddPostRequest request) {
        Long savedPostId = postService.addPost(user, request);

        return ResponseEntity.created(URI.create("/posts/" + savedPostId)).build();
    }

    @PutMapping("/api/post/{id}")
    public ResponseEntity<?> modifyPost(@PathVariable Long id,
                                        @RequestBody UpdatePostRequest request) {
        Long updatedPostId = postService.updatePostById(id, request);

        return ResponseEntity.created(URI.create("/posts/" + updatedPostId)).build();
    }

    @DeleteMapping("/api/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        postService.deletePostById(id);

        return ResponseEntity.ok().build();
    }
}
