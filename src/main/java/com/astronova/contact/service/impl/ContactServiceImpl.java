package com.astronova.contact.service.impl;

import com.astronova.contact.dto.ContactRequest;
import com.astronova.contact.dto.ContactResponse;
import com.astronova.contact.entity.Contact;
import com.astronova.contact.enums.LeadStatus;
import com.astronova.contact.repository.ContactRepository;
import com.astronova.contact.service.ContactService;
import com.astronova.email.service.EmailService;
import com.astronova.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final EmailService emailService;

    @Override
    public ContactResponse createContact(ContactRequest request) {

        Contact contact = Contact.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .projectType(request.getProjectType())
                .budget(request.getBudget())
                .message(request.getMessage())
                .build();

        Contact savedContact =
                contactRepository.save(contact);

//        emailService.sendContactNotification(
//                savedContact
//        );

//         nProduction ready
        try {

            emailService.sendContactNotification(
                    savedContact
            );

        } catch (Exception ex) {

            System.err.println(
                    "EMAIL FAILED: "
                            + ex.getMessage()
            );
        }

        return mapToResponse(savedContact);
    }

    @Override
    public List<ContactResponse> getAllContacts() {

        return contactRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ContactResponse getContactById(Long id) {

        Contact contact =
                contactRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Contact not found"
                                ));

        return mapToResponse(contact);
    }

    @Override
    public void deleteContact(Long id) {

        Contact contact =
                contactRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Contact not found"
                                ));

        contactRepository.delete(contact);
    }

    @Override
    public ContactResponse updateStatus(
            Long id,
            LeadStatus status) {

        Contact contact =
                contactRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Contact not found"));

        contact.setStatus(status);

        Contact updated =
                contactRepository.save(contact);

        return mapToResponse(updated);
    }

    private ContactResponse mapToResponse(
            Contact contact) {

        return ContactResponse.builder()
                .id(contact.getId())
                .name(contact.getName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .projectType(contact.getProjectType())
                .budget(contact.getBudget())
                .message(contact.getMessage())
                .status(contact.getStatus())
                .createdAt(contact.getCreatedAt())
                .build();
    }

}
