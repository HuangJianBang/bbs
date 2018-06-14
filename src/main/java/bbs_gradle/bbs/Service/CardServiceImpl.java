package bbs_gradle.bbs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import bbs_gradle.bbs.model.Card;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CardServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void markLevel() {

    }

    @Override
    public void moveTop() {

    }
    @Override
    public void addCard(Card card, Long userid) {
        jdbcTemplate.update(
                "insert into card " + "(user_id,level,content,mark)" + "values(?,?,?,?)",
                userid,card.getLevel(),card.getContent(),card.getMark()
        );
    }
    @Override
    public List<Card> listCards() {
       return jdbcTemplate.query("select id, content,level,user_id,mark"
                       + " from card order by id desc",
               new RowMapper<Card>() {
                   @Override
                   public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
                       Card card = new Card();
                       card.setId(rs.getLong(1));
                       card.setContent(rs.getString(2));
                       card.setLevel(rs.getInt(3));
                       card.setUserId(rs.getLong(4));
                       card.setMark(rs.getBoolean(5));
                       return card;
                   }
               });
    }
}
//return jdbc.query("select id, firstName, lastName, phoneNumber, emailAddress"
//        + " from contacts order by lastName",
//        new RowMapper<Contact>() {
//@Override
//public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Contact contact = new Contact();
//        contact.setId(rs.getLong(1));
//        contact.setFirstName(rs.getString(2));
//        contact.setLastName(rs.getString(3));
//        contact.setPhoneNumber(rs.getString(4));
//        contact.setEmailAddress(rs.getString(5));
//        return contact;
//        }
//        });
