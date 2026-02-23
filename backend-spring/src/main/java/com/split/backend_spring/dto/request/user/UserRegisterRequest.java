package com.split.backend_spring.dto.request.user;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    @Size(min= 5)
    private String password;


}
