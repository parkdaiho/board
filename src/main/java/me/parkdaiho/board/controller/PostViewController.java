package me.parkdaiho.board.controller;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.dto.PostListResponse;
import me.parkdaiho.board.dto.PostViewResponse;
import me.parkdaiho.board.service.PostService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostViewController {

    private final PostService postService;

    @GetMapping("/posts")
    public String posts(@Nullable Integer page, Model model) {
        List<PostListResponse> lists;

        if(page == null) {
            lists = postService.lists(0);
        } else {
            lists = postService.lists(page - 1);
        }

        model.addAttribute("lists", lists);

        return "list";
    }
}
