package me.parkdaiho.board.controller;

import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.service.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PostApiController {

    private final PostService postService;

    @GetMapping("/api/addTest")
    public void addTest(@AuthenticationPrincipal User user) {
        postService.add27Posts(user);
    }
}
