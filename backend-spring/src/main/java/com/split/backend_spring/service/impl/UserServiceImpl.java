package com.split.backend_spring.service.impl;

import com.split.backend_spring.exception.user.UserNotFoundException;
import com.split.backend_spring.model.User;
import com.split.backend_spring.repository.UserRepository;
import com.split.backend_spring.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {

    public UserRepository userRepo;
    public PasswordEncoder passwordEncoder;

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public User saveUser(User u) {
        return userRepo.save(u);
    }

    @Override
    public void deleteUserById(Long id) {
        User u = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        userRepo.delete(u);
    }

}
