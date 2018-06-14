package bbs_gradle.bbs.controller;


import bbs_gradle.bbs.Service.AdministratorServiceImpl;
import bbs_gradle.bbs.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String deleteCard() {

        return "redirect:/admin";
    }
}
