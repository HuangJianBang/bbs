package com.javagroup.bbs.service;

import com.javagroup.bbs.domain.User;


import java.util.Optional;

public interface UserService {

    User saveOrUpdateUser(User user);

    User registerUser(User user);

    Optional<User> getUserById(Long id);
}
