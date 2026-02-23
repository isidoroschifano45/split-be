package com.split.backend_spring.dto.request.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLogIn {
    private String email;
    private String password;

}
