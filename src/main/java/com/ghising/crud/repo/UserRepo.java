package com.ghising.crud.repo;

import com.ghising.crud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String username);
}
