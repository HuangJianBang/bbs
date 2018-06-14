package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.model.Card;

import java.util.List;

public interface CardService {
    void mark(Long cardid);
    void moveTop();
    void addCard(Card card, String userName);
    List<Card> listCards();
}
