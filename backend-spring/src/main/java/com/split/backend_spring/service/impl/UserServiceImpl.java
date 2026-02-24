package com.split.backend_spring.service.impl;

import com.split.backend_spring.dto.request.user.UserLogIn;
import com.split.backend_spring.exception.user.UserAlreadySignIn;
import com.split.backend_spring.exception.user.UserNotFoundException;
import com.split.backend_spring.model.User;
import com.split.backend_spring.repository.UserRepository;
import com.split.backend_spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " + id + "not found"));
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + "not found"));
    }

    @Override
    public User saveUser(User u) {
        return userRepo.save(u);
    }

    @Override
    public void deleteUserById(Long id) {
        User u = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with id: " + id + "not found"));
        userRepo.delete(u);
    }
    
    @Override
    public User userSignIn(User u) {
        userRepo.findUserByEmail(u.getEmail()).ifPresent(user -> {
            throw new UserAlreadySignIn("User with email: " + u.getEmail() + " is already registered");
        });
        userRepo.findUserByUsername(u.getUsername()).ifPresent(user -> {
            throw new UserAlreadySignIn("User with username: " + u.getUsername() + " is already registered");
        });
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return userRepo.save(u);
    }

    @Override
    public User logIn(UserLogIn u) {
        User userLogged = userRepo.findUserByEmail(u.getEmail()).orElseThrow(() -> new UserNotFoundException("User with email: " + u.getEmail() + "not found"));
        if(!passwordEncoder.matches(u.getPassword(), userLogged.getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password errata");
        }
        return userLogged;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + "not found"));
    }
}
