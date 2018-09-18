package com.example.Events.models.services;

import com.example.Events.models.entities.UserEntity;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class SessionService {
    private boolean isLoggedIn;
    private UserEntity userEntity;
}
