package bbs_gradle.bbs.controller;

import bbs_gradle.bbs.dao.UserRepository;
import bbs_gradle.bbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

//    @PostMapping("/login")
//    public String login() {
//        return null;
//    }
}
