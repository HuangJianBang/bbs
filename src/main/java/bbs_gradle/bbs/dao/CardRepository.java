package bbs_gradle.bbs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import bbs_gradle.bbs.model.Card;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {
    public List<Card> findAll();

//    public List<Contact> findAll() {
//        return jdbc.query("select id, firstName, lastName, phoneNumber, emailAddress"
//                        + " from contacts order by lastName",
//                new RowMapper<Contact>() {
//                    @Override
//                    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        Contact contact = new Contact();
//                        contact.setId(rs.getLong(1));
//                        contact.setFirstName(rs.getString(2));
//                        contact.setLastName(rs.getString(3));
//                        contact.setPhoneNumber(rs.getString(4));
//                        contact.setEmailAddress(rs.getString(5));
//                        return contact;
//                    }
//                });
    }
