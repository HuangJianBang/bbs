package com.bbs_gradle.service;

import com.bbs_gradle.domain.User;


import java.util.Optional;

public interface UserService {

    User saveOrUpdateUser(User user);

    User registerUser(User user);

    Optional<User> getUserById(Long id);
}
