package com.awatif.field_portalarea.repositories;

import com.awatif.field_portalarea.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
