package com.webservice.rabbitmq.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.rabbitmq.model.User;
import com.webservice.rabbitmq.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) throws JsonProcessingException {
        User newUser = userService.registerUser(user);
        String userJson = objectMapper.writeValueAsString(newUser);
        rabbitTemplate.convertAndSend("rabbit-exchange", "rabbit-routing", userJson);
        return ResponseEntity.ok("Utilisateur créé avec succès");
    }
}
