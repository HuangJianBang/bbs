package bbs_gradle.bbs.controller;

import bbs_gradle.bbs.Service.MyCardServiceImpl;
import bbs_gradle.bbs.dao.UserRepository;
import bbs_gradle.bbs.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MyCardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MyCardServiceImpl myCardServiceImpl;

    @RequestMapping("/mycard")
    public String listMycard(Map<String, Object> model) {
        String userName = getCurrentUserName();
        List<Card> mycards = myCardServiceImpl.listMycard(userName);

        model.put("mycards", mycards);

        return "mycard";
    }

    @RequestMapping("/mycard/delete")
    public String deleteMycard(@RequestParam("cardid") Long cardid) {
        myCardServiceImpl.deleteMycard(cardid);
        return "redirect:/mycard";
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

    //返回当前登陆用户的名字
    private String getCurrentUserName() {
        UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userDetails.getUsername();

    }
}
