package com.javagroup.bbs.repository;

import com.javagroup.bbs.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
