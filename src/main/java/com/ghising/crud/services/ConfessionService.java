package com.ghising.crud.services;

import com.ghising.crud.dto.ConfessionDTO;
import com.ghising.crud.entity.PostEntity;
import com.ghising.crud.entity.UserEntity;
import com.ghising.crud.repo.ConfessionRepo;
import com.ghising.crud.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConfessionService {

    private final ConfessionRepo confessionRepo;
    private final UserRepo userRepo;

    public ConfessionDTO getConfessionById(UUID id) {
        PostEntity post = confessionRepo.findById(id)
                .orElseThrow(() -> new ResolutionException("Confession not found: " + id));
        
        ConfessionDTO confessionDTO = new ConfessionDTO();
        confessionDTO.setId(post.getId());
        confessionDTO.setTitle(post.getTitle());
        confessionDTO.setContent(post.getContent());
        confessionDTO.setAuthor(post.getAuthor());
        confessionDTO.setCreatedAt(post.getCreatedAt());
        
        if (post.getAuthor() != null) {
            confessionDTO.setAuthorUsername(post.getAuthor().getUsername());
        }
        
        return confessionDTO;
    }

    public List<PostEntity> getAllConfessions() {
        return confessionRepo.findAll();
    }

    public void createConfession(ConfessionDTO confessionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        UserEntity user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResolutionException("User not found"));
        PostEntity post = new PostEntity();
        post.setTitle(confessionDTO.getTitle());
        post.setContent(confessionDTO.getContent());
        post.setAuthor(user);
        post.setCreatedAt(new Date());
        confessionRepo.save(post);
    }
    
    public List<PostEntity> getConfessionsByUser(String username) {
        UserEntity user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResolutionException("User not found"));
        
        return confessionRepo.findByAuthor(user);
    }
}