package com.ghising.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String name;
    private String username;
    private String password;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<PostEntity> confessions = new ArrayList<>();

}