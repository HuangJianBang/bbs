package bbs_gradle.bbs.controller;

import bbs_gradle.bbs.dao.UserRepository;
import bbs_gradle.bbs.model.User;
import bbs_gradle.bbs.util.FileUtil;
import bbs_gradle.bbs.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(User user) {
        user.setPassword(MD5Util.encode(user.getPassword()));
        System.out.println(user.getPassword());
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String userspace(ModelMap model) {
        User user = userRepository.getOne(getCurrentUserId());
        model.addAttribute("user", user);
        return "/users/profile";
    }

    @PostMapping("/updateAvater")
    public String updateAvater(@RequestParam("user_pic")MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();   //图片文件类型
        String fileName = file.getOriginalFilename();  //图片名字
        String filePath = "src/main/resources/static/upload/";

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/users/profile";
    }

    @PostMapping("/update")
    public String update(User user) {
        Long id = getCurrentUserId();

        if (user.getPassword().equals("")) {
            user.setPassword(userRepository.getOne(id).getPassword());
        } else {
            user.setPassword(MD5Util.encode(user.getPassword()));
        }

        user.setId(id);
        userRepository.save(user);
        return "redirect:/users/profile";
    }

    /**
     * @return 当前登陆用户的Id
     */
    private Long getCurrentUserId() {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        return userRepository.findByUsername(username).getId();
    }
}
