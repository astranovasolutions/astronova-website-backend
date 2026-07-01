package com.astronova.contact.controller;

import com.astronova.contact.dto.ContactRequest;
import com.astronova.contact.dto.ContactResponse;
import com.astronova.contact.dto.UpdateLeadStatusRequest;
import com.astronova.contact.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/contact")
    public ContactResponse createContact(
            @Valid
            @RequestBody ContactRequest request) {

        return contactService.createContact(request);
    }

    @GetMapping("/admin/contacts")
    public List<ContactResponse> getAllContacts() {

        return contactService.getAllContacts();
    }

    @GetMapping("/admin/contacts/{id}")
    public ContactResponse getContactById(
            @PathVariable Long id) {

        return contactService.getContactById(id);
    }

    @DeleteMapping("/admin/contacts/{id}")
    public void deleteContact(
            @PathVariable Long id) {

        contactService.deleteContact(id);
    }

    @PutMapping("/admin/contacts/{id}/status")
    public ContactResponse updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateLeadStatusRequest request) {

        return contactService.updateStatus(
                id,
                request.getStatus());
    }

}
