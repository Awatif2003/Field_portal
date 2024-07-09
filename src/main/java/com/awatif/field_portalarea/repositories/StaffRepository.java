package com.awatif.field_portalarea.repositories;

import com.awatif.field_portalarea.models.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity,Long> {
}
