package com.split.backend_spring.mapper.user;

import com.split.backend_spring.dto.request.user.UserRegisterRequest;
import com.split.backend_spring.dto.response.user.UserResponse;
import com.split.backend_spring.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    /**
     * Converte un UserRegisterRequest in un User
     * @param request il DTO di registrazione dell'utente
     * @return un oggetto User con i dati del request
     */
    public User toUser(UserRegisterRequest request) {
        if (request == null) {
            return null;
        }

        User user = new User();
        user.setFirstname(request.getFirstName());
        user.setLastname(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setAvatar(""); // Avatar vuoto di default
        user.setCreatedAt(LocalDateTime.now());

        return user;
    }

    /**
     * Converte un User in un UserRegisterResponse
     * @param user l'entità User
     * @return il DTO di risposta con i dati pubblici dell'utente
     */
    public UserResponse toUserRegisterResponse(User user) {
        if (user == null) {
            return null;
        }

        UserResponse response = new UserResponse();
        response.setIdUser(user.getId());
        response.setFirstName(user.getFirstname());
        response.setLastName(user.getLastname());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setCreatedAt(user.getCreatedAt());

        return response;
    }
}
