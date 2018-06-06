package bbs_gradle.bbs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserServiceIm implements UserService {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbc;

    @Override
    public void addUser(String name, String password, String phone) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("insert into user(name, phone, password) " +
                "values(?,?,?)",name, phone, password);
    }

    @Override
    public void deleteUser(String name, String phone) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("delete from user where name=" + name + " AND id=" + "id");
    }
}
