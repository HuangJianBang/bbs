package bbs_gradle.bbs.controller;

import bbs_gradle.bbs.Service.CommentServiceImpl;
import bbs_gradle.bbs.dao.CommentRepository;
import bbs_gradle.bbs.dao.UserRepository;
import bbs_gradle.bbs.model.Card;
import bbs_gradle.bbs.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentServiceImpl commentServiceImpl;

    @Autowired
    private UserRepository userRepository;

    private List<Card> cardList;

    //先将选中的card给
    @GetMapping("/card/comment")
    private String displayCardContent(Map<String, Object> model,
                                  @RequestParam("cardid") Long cardid) {
        List<Card> cards = commentServiceImpl.displayCard(cardid);

        List<Comment> comments = commentServiceImpl.showComment(cardid);

        model.put("comments", comments);

        model.put("cards", cards);
        return "comment";
    }

    @PostMapping("/card/comment")
    private String addComment(Comment comment, Long userid, Map<String, Object> model,
                              @RequestParam("cardid") Long cardid) {

        userid = getCurrentUserId();
        commentServiceImpl.addComment(comment, userid, cardid);
        List<Comment> comments = commentServiceImpl.showComment(cardid);

        List<Card> cards = commentServiceImpl.displayCard(cardid);

        model.put("cards", cards);

        model.put("comments", comments);

        return "comment";
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
