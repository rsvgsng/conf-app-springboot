package com.ghising.crud.repo;

import com.ghising.crud.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConfessionRepo extends JpaRepository<PostEntity, UUID> {
}
