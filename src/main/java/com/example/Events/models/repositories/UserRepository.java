package com.example.Events.models.repositories;

import com.example.Events.models.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <UserEntity, Integer>{
    boolean existsByEmail(String email);
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
