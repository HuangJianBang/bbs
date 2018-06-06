package bbs_gradle.bbs.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bbs_gradle.bbs.model.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {
}
