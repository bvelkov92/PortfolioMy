package org.portfolio.service.serviceImpl;

import lombok.Getter;
import lombok.Setter;
import org.portfolio.models.dto.user.UserRegisterDTO;
import org.portfolio.models.entity.User;
import org.portfolio.repository.UserRepository;
import org.portfolio.service.serviceAnotations.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Getter
@Setter
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerNewUser(UserRegisterDTO userRegisterDTO) {
        Optional<User> foundUsername = this.userRepository.findByUsername(userRegisterDTO.getUsername());

        if (foundUsername.isEmpty()){
            User newUser = new User();
             newUser.setUsername(userRegisterDTO.getUsername());
             newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
             newUser.setEmail(userRegisterDTO.getEmail());
             newUser.setAge(userRegisterDTO.getAge());
             newUser.setCity(userRegisterDTO.getCity());

             this.userRepository.save(newUser);
        }
    }
}
