package com.split.backend_spring.dto.request.user;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterRequest {
    public String firstName;
    public String lastName;
    public String username;
    public String email;
    @Size(min= 5)
    public String password;


}
