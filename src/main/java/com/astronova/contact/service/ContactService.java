package com.astronova.contact.service;

import com.astronova.contact.dto.ContactRequest;
import com.astronova.contact.dto.ContactResponse;
import com.astronova.contact.enums.LeadStatus;

import java.util.List;

public interface ContactService {

    ContactResponse createContact(ContactRequest request);
    List<ContactResponse> getAllContacts();
    ContactResponse getContactById(Long id);
    void deleteContact(Long id);

    ContactResponse updateStatus(
            Long id,
            LeadStatus status);

}
