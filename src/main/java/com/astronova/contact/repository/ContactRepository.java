package com.astronova.contact.repository;

import com.astronova.contact.entity.Contact;
import com.astronova.contact.enums.LeadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    long countByStatus(LeadStatus status);
}
