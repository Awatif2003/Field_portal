package com.awatif.field_portalarea.services;

import com.awatif.field_portalarea.models.UserEntity;
import com.awatif.field_portalarea.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    public UserEntity saveUser(UserEntity user) {
        return repository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return repository.findAll();
    }

   public Optional<UserEntity> getUserByID(Long id) {
        return repository.findById(id);
   }

   public void deleteUser(Long id) {
        repository.deleteById(id);
   }

   public boolean isExist(Long id) {
        return repository.existsById(id);
   }
}
