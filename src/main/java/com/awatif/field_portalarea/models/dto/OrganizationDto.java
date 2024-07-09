package com.awatif.field_portalarea.models.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrganizationDto {
    private Long OrganizationID;
    private String OrganizationName;
    private String Address;
    private String Status;
}
