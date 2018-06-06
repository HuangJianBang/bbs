package com.javagroup.bbs.controller;

import com.javagroup.bbs.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register(User user) {
        return "/users/login";
    }
}
