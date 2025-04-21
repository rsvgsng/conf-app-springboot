package com.ghising.crud.repo;

import com.ghising.crud.entity.PostEntity;
import com.ghising.crud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConfessionRepo extends JpaRepository<PostEntity, UUID> {
    List<PostEntity> findByAuthor(UserEntity author);
}