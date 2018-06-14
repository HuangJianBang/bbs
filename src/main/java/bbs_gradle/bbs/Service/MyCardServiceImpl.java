package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class MyCardServiceImpl implements MyCardService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MyCardServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //将登录用户所写过的帖子列出来
    @Override
    public List<Card> listMycard(Long userid) {
        return jdbcTemplate.query("select id, content, level, mark, user_id" +
                        " from card where user_id = ?", new Object[]{userid},
                new RowMapper<Card>() {
                    @Override
                    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Card card = new Card();
                        card.setId(rs.getLong(1));
                        card.setContent(rs.getString(2));
                        card.setLevel(rs.getInt(3));
                        card.setMark(rs.getBoolean(4));
                        card.setUserId(rs.getLong(5));
                        return card;
                    }
                });
    }

    @Override
    public void deleteMycard(Long cardid) {
        //删除帖子
        jdbcTemplate.update("delete from card where id = ?",
                new Object[]{cardid});

        //删除帖子下的评论
        jdbcTemplate.update("delete from comment where card_id = ?",
                new Object[]{cardid});
    }
}
