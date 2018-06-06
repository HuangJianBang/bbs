package bbs_gradle.bbs.Service;

public interface UserService {
    void addUser(String name, String password, String phone);
    void deleteUser(String name, String phone);
}
