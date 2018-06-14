package bbs_gradle.bbs.controller;

import bbs_gradle.bbs.Service.common.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;

import bbs_gradle.bbs.dao.UserRepository;

@Controller
public class CommonController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    CommonServiceImpl commonServiceImpl;

    @PostMapping("/change/secret")
    public String changeSecret(HttpServletRequest request){
        Long userid = getCurrentUserId();
        commonServiceImpl.changeSecret(request.getParameter("old-secret"),
                request.getParameter("new-secret"), userid);
        return "redirect:/";
    }

    @GetMapping("/change/secret")
    public String redirectToChangeSecret() {
        return "/secret";
    }

    @GetMapping("/administrator")
    public String checkCurrentUserIdentity() {
        String currentUserName = getCurrentUserName();
        if (currentUserName.equals("admin")) {
            return "redirect:/admin";
        } else {
            return "redirect:/mycard";
        }
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

    //获取用户名字
    private String getCurrentUserName() {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }
}
