package com.emailsender.Service;

import com.emailsender.DTO.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendPortfolioMessage(EmailDTO request) {
        System.out.println("Preparing mail...");
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("atharvj164@gmail.com");
        mail.setSubject("New Portfolio Contact Message");

        mail.setText(
                "Name: " + request.getName() + "\n\n" +
                        "Email: " + request.getEmail() + "\n\n" +
                        "Message:\n" + request.getMessage());

        mailSender.send(mail);
        System.out.println("Mail sent successfully");
    }
}