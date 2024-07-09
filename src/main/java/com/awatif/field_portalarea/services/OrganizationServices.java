package com.awatif.field_portalarea.services;

import com.awatif.field_portalarea.models.OrganizationEntity;
import com.awatif.field_portalarea.repositories.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServices {
    private OrganizationRepository repository;

    public OrganizationServices(OrganizationRepository organizationRepository) {
        this.repository = organizationRepository;
    }
    public OrganizationEntity saveOrganization(OrganizationEntity organization ) {
        return repository.save(organization);
    }
    public List<OrganizationEntity> getAllOrganization() {
        return repository.findAll();
    }

    public Optional<OrganizationEntity> getOrgByID(Long id) {
        return repository.findById(id);
    }

    public void deleteOrganization(Long id) {
        repository.deleteById(id);
    }

    public boolean isExist(Long id) {
        return repository.existsById(id);
    }

}

