package org.portfolio.models.dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginDTO {

    private String username;
    private String password;
}
