package me.parkdaiho.board.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class UserViewController {

    @GetMapping("/sign-up")
    public String signUpPage() {
        return "sign-up";
    }

    @GetMapping("/posts")
    public String postListPage() {
        return "list";
    }

    @GetMapping("/post")
    public String newPost() {
        return "write";
    }
}
