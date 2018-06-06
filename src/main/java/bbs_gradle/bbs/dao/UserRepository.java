package bbs_gradle.bbs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bbs_gradle.bbs.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}
