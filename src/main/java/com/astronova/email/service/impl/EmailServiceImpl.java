package com.astronova.email.service.impl;

import com.astronova.contact.entity.Contact;
import com.astronova.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl
        implements EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${astronova.admin.email}")
    private String adminEmail;

    @Override
    public void sendContactNotification(
            Contact contact) {

        SimpleMailMessage message =
                new SimpleMailMessage();

        message.setFrom(fromEmail);

        message.setTo(adminEmail);

        message.setSubject(
                "New Contact Form Submission"
        );

        message.setText(
                """
                New Lead Received

                Name: %s
                Email: %s
                Phone: %s
                Project Type: %s
                Budget: %s

                Message:
                %s
                """
                        .formatted(
                                contact.getName(),
                                contact.getEmail(),
                                contact.getPhone(),
                                contact.getProjectType(),
                                contact.getBudget(),
                                contact.getMessage()
                        )
        );

        mailSender.send(message);
    }
}