package org.portfolio.service.serviceImpl;

import lombok.Getter;
import lombok.Setter;
import org.portfolio.repository.UserRepository;
import org.portfolio.service.serviceAnotations.UserService;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
