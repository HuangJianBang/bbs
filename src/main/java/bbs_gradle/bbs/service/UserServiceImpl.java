package bbs_gradle.bbs.Service;

import bbs_gradle.bbs.dao.UserRepository;
import bbs_gradle.bbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id) ;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByName(name);
    }
}
