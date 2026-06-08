package org.portfolio.service.serviceAnotations;
import org.portfolio.models.dto.user.UserRegisterDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    void registerNewUser(UserRegisterDTO userRegisterDTO);
}
