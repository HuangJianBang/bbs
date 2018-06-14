package bbs_gradle.bbs.Service.common;

import bbs_gradle.bbs.model.User;

import java.util.List;

public interface CommonService {
    void changeSecret(String oldSecret, String newSecret, Long userid);
}
