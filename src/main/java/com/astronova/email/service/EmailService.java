package com.astronova.email.service;

import com.astronova.contact.entity.Contact;

public interface EmailService {

    void sendContactNotification(
            Contact contact
    );
}