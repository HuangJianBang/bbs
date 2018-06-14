package bbs_gradle.bbs.controller;

import bbs_gradle.bbs.dao.UserRepository;
import bbs_gradle.bbs.model.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bbs_gradle.bbs.Service.CardService;
import bbs_gradle.bbs.dao.CardRepository;
import bbs_gradle.bbs.model.Card;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.Map;

@Controller
public class MainController {

   @Autowired
    UserRepository userRepository;
  
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardService cardService;


    @PostMapping("/")
    public String submit(Card card, Map<String, Object> model, String userName) {

        userName = getCurrentUserName();
        cardService.addCard(card, userName);

        List<Card> cards = cardService.listCards();
        model.put("cards", cards);

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


    @GetMapping("/")
    public String index(Map<String, Object> model) {
        List<Card> cards = cardService.listCards();
        model.put("cards", cards);
        return "index";
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
