package me.parkdaiho.board.controller;

import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.dto.post.PostViewResponse;
import me.parkdaiho.board.dto.post.UpdatePostResponse;
import me.parkdaiho.board.service.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class PostViewController {

    private final PostService postService;

    private final int SIZE = 10;
    private final int BLOCK_SIZE = 10;

    @GetMapping("/posts")
    public String posts(@RequestParam(defaultValue = "1", required = true) Integer page, Model model) {
        Map<String, Object> posts;
        posts = postService.list(page - 1, SIZE);

        int totalPages = (Integer) posts.get("totalPages");
        int blockNum = page / BLOCK_SIZE;
        int firstNumOfBlock = blockNum * BLOCK_SIZE + 1;
        int lastNumOfBlock = Math.min(blockNum * BLOCK_SIZE + 10, totalPages);

        model.addAttribute("page", page);
        model.addAttribute("count", posts.get("count"));
        model.addAttribute("list", posts.get("list"));
        model.addAttribute("fistNumOfBlock", firstNumOfBlock);
        model.addAttribute("lastNumOfBlock", lastNumOfBlock);
        model.addAttribute("totalPages", totalPages);

        return "list";
    }

    @GetMapping("/post")
    public String newPost() {
        return "write";
    }

    @GetMapping("/post/{id}")
    public String modifyPost(@PathVariable Long id, Model model) {
        UpdatePostResponse post = new UpdatePostResponse(postService.findById(id));

        model.addAttribute("post", post);

        return "write";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Long id, Model model
            , @AuthenticationPrincipal User user) {
        PostViewResponse post = new PostViewResponse(postService.findById(id), user);

        model.addAttribute("post", post);

        return "view";
    }
}
