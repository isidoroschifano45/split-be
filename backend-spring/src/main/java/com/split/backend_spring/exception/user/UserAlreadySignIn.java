package com.split.backend_spring.exception.user;

public class UserAlreadySignIn extends RuntimeException {
    public UserAlreadySignIn(String message) {
        super(message);
    }
}
