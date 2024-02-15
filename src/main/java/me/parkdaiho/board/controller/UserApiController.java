package me.parkdaiho.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.dto.user.RegisterUserRequest;
import me.parkdaiho.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public String signUp(@Valid RegisterUserRequest request) {
        User savedUser = userService.registerUser(request);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        if(userService.logout(request, response)) {
            return "redirect:/?logout=success";
        } else {
            return "redirect:/?logout=fail";
        }
    }
}
