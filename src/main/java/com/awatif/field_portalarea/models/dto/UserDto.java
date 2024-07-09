package com.awatif.field_portalarea.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long userID;
    private String username;
    private String fullname;
    private String password;
    private String email;
    private String role;
}
