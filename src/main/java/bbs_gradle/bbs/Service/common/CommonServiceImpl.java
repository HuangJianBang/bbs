package bbs_gradle.bbs.Service.common;

import bbs_gradle.bbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import bbs_gradle.bbs.util.MD5Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CommonServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void changeSecret(String oldSecret, String newSecret, Long userid) {
        List<User> userList = getUserInfo(userid);
        if (userList.size() != 0) {
            if (MD5Util.encode(oldSecret).equals(userList.get(0).getPassword())) {
                jdbcTemplate.update("update user set password = ? where id = ?",
                        MD5Util.encode(newSecret), userid);
            } else {
                System.out.println("Error");
            }
        } else {}
//        UPDATE Person SET FirstName = 'Fred' WHERE LastName = 'Wilson'
    }

    public List<User> getUserInfo(Long userid) {
        return jdbcTemplate.query("select password,username,phone from user where id = ?",
                new Object[]{userid},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User("zhangsan", "123", "12345678901");
                        user.setUsername(rs.getString(2));
                        user.setPhone(rs.getString(3));
                        user.setPassword(rs.getString(1));
                        return user;
                    }
                });
    }
}
