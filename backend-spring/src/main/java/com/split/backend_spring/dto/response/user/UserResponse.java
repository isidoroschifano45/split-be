package com.split.backend_spring.dto.response.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

    private Long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String avatar;
    private LocalDateTime createdAt;


}
