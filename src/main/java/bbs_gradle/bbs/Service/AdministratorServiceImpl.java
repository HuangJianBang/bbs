package bbs_gradle.bbs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AdministratorServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void listCard() {

    }

    @Override
    public void deleteCard() {

    }
}
