package com.split.backend_spring.service;

import com.split.backend_spring.dto.request.user.UserLogIn;
import com.split.backend_spring.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

    User findById(Long id);
    User findUserByUsername(String username);
    @Deprecated
    User saveUser(User u);
    void deleteUserById(Long id);
    User userSignIn(User u);
    User logIn(UserLogIn u);

}
