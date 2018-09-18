package com.example.Events.models.services;

import com.example.Events.models.entities.UserEntity;
import com.example.Events.models.forms.RegisterForm;
import com.example.Events.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final SessionService sessionService;


    @Autowired
    public AuthenticationService(UserRepository userRepository, SessionService sessionService) {
        this.userRepository = userRepository;
        this.sessionService = sessionService;
    }

    public boolean tryLogin(String email, String password){
        Optional<UserEntity> userEntity = userRepository.findByEmailAndPassword(email, password);
        if(userEntity.isPresent()){
            sessionService.setLoggedIn(true);
            sessionService.setUserEntity(userEntity.get());

        }
        return userEntity.isPresent();
    }

    public boolean tryToRegister(RegisterForm registerForm){
        if(userRepository.existsByEmail(registerForm.getEmail())){
            return false;
        }

        UserEntity userEntity = createEntityFromForm(registerForm);
        userRepository.save(userEntity);
        return true;
    }

    private UserEntity createEntityFromForm(RegisterForm registerForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerForm.getEmail());
        userEntity.setPassword(registerForm.getPassword());
        userEntity.setUsername(registerForm.getUsername());
        return userEntity;
    }
}
