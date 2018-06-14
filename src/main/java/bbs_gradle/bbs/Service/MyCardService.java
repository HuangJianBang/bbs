package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.model.Card;

import java.util.List;

public interface MyCardService {
    List<Card> listMycard(Long userid);
    void deleteMycard(Long cardid);
}
