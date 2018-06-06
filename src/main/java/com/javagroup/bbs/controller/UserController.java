package com.javagroup.bbs.controller;

import com.javagroup.bbs.domain.User;
import com.javagroup.bbs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(User user) {
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login() {
        return null;
    }
}
