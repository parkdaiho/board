package me.parkdaiho.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.Post;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.service.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PostViewController {

    private final PostService postService;

    @GetMapping("/posts")
    public String list(){
        return "posts";
    }

    @GetMapping("/posts/{id}")
    public String post(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);

        model.addAttribute("post", post);

        return "post";
    }

    @GetMapping("/post")
    public String newPost(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("userId", user.getId());

        return "write_post";
    }
}
