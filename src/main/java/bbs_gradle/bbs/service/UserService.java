package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.model.User;


import java.util.Optional;

public interface UserService {

    User saveOrUpdateUser(User user);

    User registerUser(User user);

}
