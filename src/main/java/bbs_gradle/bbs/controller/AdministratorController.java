package bbs_gradle.bbs.controller;


import bbs_gradle.bbs.Service.AdministratorServiceImpl;
import bbs_gradle.bbs.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AdministratorController {

    @Autowired
    private AdministratorServiceImpl administratorServiceImpl;

    @GetMapping("/admin")
    public String listCards(Map<String, Object> model) {

        List<Card> cards = administratorServiceImpl.listCards();
        model.put("cards", cards);

        return "/admin";
    }

    @GetMapping("/admin/delete")
    public String deleteCard(@RequestParam("cardid") Long cardid) {

        administratorServiceImpl.deleteCard(cardid);

        return "redirect:/admin";
    }

    @GetMapping("/admin/mark")
    public String mark(@RequestParam("cardid") Long cardid) {

        administratorServiceImpl.mark(cardid);
        return "redirect:/admin";
    }
}
