package bbs_gradle.bbs.service;

import bbs_gradle.bbs.domain.User;


import java.util.Optional;

public interface UserService {

    User saveOrUpdateUser(User user);

    User registerUser(User user);

    Optional<User> getUserById(Long id);
}
