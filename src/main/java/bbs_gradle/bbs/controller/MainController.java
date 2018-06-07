package bbs_gradle.bbs.controller;

import bbs_gradle.bbs.Service.CardService;
import bbs_gradle.bbs.dao.CardRepository;
import bbs_gradle.bbs.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardService cardService;

    private List<Card> cardModelList;

    @GetMapping("/card")
    public String submit(Card card) {
        cardService.addCard(card);
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
    @PostMapping("/register")
    public String register(Card card) {
       cardService.addCard(card);
        return "index";
//        return "/index";
    }
    @GetMapping("/")
    public String index(Map<String, Object> model) {
        List<Card> cards = cardService.listCards();
        model.put("cards", cards);
        return "index";
    }

}
