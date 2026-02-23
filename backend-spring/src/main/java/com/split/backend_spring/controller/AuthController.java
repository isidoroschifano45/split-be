package com.split.backend_spring.controller;

import com.split.backend_spring.dto.request.user.UserLogIn;
import com.split.backend_spring.dto.request.user.UserRegisterRequest;
import com.split.backend_spring.dto.response.user.UserResponse;
import com.split.backend_spring.mapper.user.UserMapper;
import com.split.backend_spring.model.User;
import com.split.backend_spring.security.config.JwtUtilities;
import com.split.backend_spring.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Controller dell' AUTENTICAZIONE", description = "API per login e Registrazione")
public class AuthController {

    private final JwtUtilities  jwtUtilities;
    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(summary = "Esegui il login")
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody UserLogIn userLogIn){
        User login = userService.logIn(userLogIn);
        String token = jwtUtilities.generaToken(login);


        return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.AUTHORIZATION, token).body(userMapper.toUserRegisterResponse(login));
    }

    @Operation(summary = "Registra un utente")
    @PostMapping("/registrazione")
    public ResponseEntity<UserResponse> registraUtente(@Valid @RequestBody UserRegisterRequest u){
        User utenteSalvato = userService.userSignIn(userMapper.toUser(u));


        return ResponseEntity.ok().body(userMapper.toUserRegisterResponse(utenteSalvato));
    }


}
