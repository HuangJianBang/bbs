package com.bbs_gradle.service;

import com.bbs_gradle.repository.UserRepository;
import com.bbs_gradle.domain.User;
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
