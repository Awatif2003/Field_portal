package com.awatif.field_portalarea.controllers;

import com.awatif.field_portalarea.models.OrganizationEntity;
import com.awatif.field_portalarea.models.dto.OrganizationDto;
import com.awatif.field_portalarea.services.OrganizationServices;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/organization")
public class OrganizationController {
    private OrganizationServices organizationServices;
    private ModelMapper modelMapper;

    public OrganizationController(OrganizationServices organizationServices, ModelMapper modelMapper) {
        this.organizationServices = organizationServices;
        this.modelMapper = modelMapper;
    }

    
    @PostMapping
    public ResponseEntity<OrganizationDto> createOrg(@RequestBody OrganizationDto organizationDto) {
        System.out.println("Received OrganizationDto: " + organizationDto);
        if (organizationDto.getOrganizationName() == null || organizationDto.getAddress() == null || organizationDto.getStatus() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        OrganizationEntity organizationEntity = modelMapper.map(organizationDto, OrganizationEntity.class);
        OrganizationEntity savedOrg = organizationServices.saveOrganization(organizationEntity);
        OrganizationDto dto = modelMapper.map(savedOrg, OrganizationDto.class);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrganizationDto>> getOrganization() {
        List<OrganizationEntity> organizationEntities = organizationServices.getAllOrganization();
        List<OrganizationDto> organizationDto = organizationEntities.stream()
                .map(organization -> modelMapper.map(organization, OrganizationDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrganizationDto> getorganizationByID(@PathVariable("id") Long id) {
        Optional<OrganizationEntity> organizationEntity = organizationServices.getOrgByID(id);
        return organizationEntity.map(entity -> new ResponseEntity<>
                        (modelMapper.map(entity, OrganizationDto.class), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteOrg(@PathVariable("id") Long id) {
        organizationServices.deleteOrganization(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
