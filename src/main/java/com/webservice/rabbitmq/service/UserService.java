package com.webservice.rabbitmq.service;

import com.webservice.rabbitmq.model.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    public User registerUser(User user) {
        String token = UUID.randomUUID().toString();
        user.setVerificationToken(token);
        return user;
    }
}
