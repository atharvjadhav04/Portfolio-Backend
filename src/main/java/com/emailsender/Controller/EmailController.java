package com.emailsender.Controller;

import com.emailsender.DTO.EmailDTO;
import com.emailsender.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> sendContactMessage(
            @RequestBody EmailDTO request) {

        try {

            if (request.getName() == null || request.getName().isBlank()) {
                return ResponseEntity.badRequest()
                        .body("Name is required");
            }

            if (request.getEmail() == null || request.getEmail().isBlank()) {
                return ResponseEntity.badRequest()
                        .body("Email is required");
            }

            if (request.getMessage() == null || request.getMessage().isBlank()) {
                return ResponseEntity.badRequest()
                        .body("Message is required");
            }

            emailService.sendPortfolioMessage(request);

            return ResponseEntity.ok("Message sent successfully");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send message");
        }
    }
}
