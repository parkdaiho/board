package me.parkdaiho.board.controller;


import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.dto.PostListResponse;
import me.parkdaiho.board.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Pageable;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserViewController {

    @GetMapping("/sign-up")
    public String signUpPage() {
        return "sign-up";
    }

    @GetMapping("/post")
    public String newPost() {
        return "write";
    }
}
