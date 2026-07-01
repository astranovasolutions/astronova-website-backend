package com.astronova.contact.dto;

import com.astronova.contact.enums.LeadStatus;
import lombok.Data;

@Data
public class UpdateLeadStatusRequest {


    private LeadStatus status;
}
