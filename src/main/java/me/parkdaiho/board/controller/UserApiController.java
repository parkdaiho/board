package me.parkdaiho.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import me.parkdaiho.board.domain.user.User;
import me.parkdaiho.board.dto.RegisterUserRequest;
import me.parkdaiho.board.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public String signUp(RegisterUserRequest request) {
        User savedUser = userService.registerUser(request);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        if(userService.logout(request, response)) {
            return "redirect:/login?logout=success";
        } else {
            return "redirect:/login?logout=fail";
        }
    }
}
