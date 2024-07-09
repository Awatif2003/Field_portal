package com.awatif.field_portalarea.models.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StaffDto {
    private Long staffID;
    private UserDto user;
    private OrganizationDto organization;
}
