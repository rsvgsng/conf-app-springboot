package com.ghising.crud.dto;

import com.ghising.crud.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfessionDTO {
    private UUID id;
    private String title;
    private String content;
    private UserEntity author;
    private Date createdAt;
    private String authorUsername;
}