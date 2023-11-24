package com.webservice.rabbitmq.rest;

import com.webservice.rabbitmq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> verifyUser(@RequestParam String token) {
        boolean isVerified = true;
        if (isVerified) {
            return ResponseEntity.ok("Compte vérifié avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Échec de la vérification.");
        }
    }
}
