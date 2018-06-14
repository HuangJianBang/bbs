package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CardServiceImpl cardServiceImpl;

    @Autowired
    private MyCardServiceImpl myCardServiceImpl;

    @Autowired
    public AdministratorServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Card> listCards() {
        return cardServiceImpl.listCards();
    }

    @Override
    public void deleteCard(Long cardid) {
        myCardServiceImpl.deleteMycard(cardid);
    }
}
