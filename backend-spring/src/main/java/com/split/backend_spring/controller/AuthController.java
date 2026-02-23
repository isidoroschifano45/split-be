package com.split.backend_spring.controller;

import com.split.backend_spring.security.config.JwtUtilities;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Controller dell' AUTENTICAZIONE", description = "API per login e Registrazione")
public class AuthController {

    public JwtUtilities  jwtUtilities;

}
