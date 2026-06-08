package org.portfolio.models.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterDTO {

    @Size(min = 2)
    private String username;

    @Email
    private String email;

    private String password;
    private String confirmPassword;

    private int age;

    private String city;

}
