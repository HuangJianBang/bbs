package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.model.Card;

import java.util.List;

public interface AdministratorService {
    List<Card> listCards();
    void deleteCard(Long cardid);
    void mark(Long cardid);
}
