package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.model.Card;

import java.util.List;

public interface CardService {
    void markLevel();
    void moveTop();
    void addCard(Card card, Long userid);
    List<Card> listCards();
}
