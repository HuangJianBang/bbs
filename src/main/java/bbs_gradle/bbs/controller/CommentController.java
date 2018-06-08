package bbs_gradle.bbs.controller;

import bbs_gradle.bbs.Service.CommentService;
import bbs_gradle.bbs.Service.CommentServiceImpl;
import bbs_gradle.bbs.dao.CommentRepository;
import bbs_gradle.bbs.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    private List<Card> cardList;

    @GetMapping("/card/comment")
    private String displayContent(Map<String, Object> model,
                                  @RequestParam("userid") Long userid,
                                  @RequestParam("cardid") Long cardid) {
        List<Card> cards = commentServiceImpl.displayCard(cardid);
        model.put("cards", cards);
        return "comment";
    }

}
