package com.awatif.field_portalarea.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "organization")
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long OrganizationID;
    @Column(name = "OrgName")
    private String OrganizationName;
    @Column(name = "Address")
    private String Address;
    @Column(name = "Status")
    private String Status;
}
