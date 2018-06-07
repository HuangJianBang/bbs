package bbs_gradle.bbs.controller;

import bbs_gradle.bbs.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(User user) {
        return "/users/login";
    }

    @GetMapping("/register")
    public String register(User user) {
        return "/users/register";
    }
}
