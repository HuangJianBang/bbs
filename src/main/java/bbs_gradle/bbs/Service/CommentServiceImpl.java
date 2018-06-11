package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.model.Card;
import bbs_gradle.bbs.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addComment(Comment comment, Long userid, Long cardid) {
        jdbcTemplate.update("insert into comment" + "(user_id, card_id, content)" + "values (?,?,?)",
                        userid, cardid, comment.getContent());
    }

    @Override
    public List<Comment> showComment(Long cardid) {
        return jdbcTemplate.query("select content,user_id from comment " +
                        "where card_id = ?", new Object[]{cardid},
                new RowMapper<Comment>() {
                    @Override
                    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Comment comment = new Comment();
                        comment.setContent(rs.getString(1));
                        comment.setUserId(rs.getLong(2));
                        return comment;
                    }
                });
    }

    @Override
    public void deleteComment() {

    }

    public List<Card> displayCard(Long carid) {
        return jdbcTemplate.query("select user_id, content, id " +
                        "from card where id= ?",  new Object[]{carid},
                new RowMapper<Card>() {
                    @Override
                    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Card card = new Card();
                        card.setUserId(rs.getLong(1));
                        card.setContent(rs.getString(2));
                        card.setId(rs.getLong(3));
                        return card;
                    }
                }
        );
    }
}
//    private Long id;
//    private Long userId;
//    private int level = 1;
//    private String content;
//    private boolean mark = false;