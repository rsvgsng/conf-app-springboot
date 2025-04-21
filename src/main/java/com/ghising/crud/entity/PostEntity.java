package com.ghising.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "Posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Title is required")
    private String title;

    @NotNull(message = "Content is required")
    private String content;

    // This annotation explicitly names the column for the foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity author;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @PrePersist
    public void prePersist() {
        createdAt = new Date();
    }
}