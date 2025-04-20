package com.ghising.crud.services;


import com.ghising.crud.dto.ConfessionDTO;
import com.ghising.crud.entity.PostEntity;
import com.ghising.crud.repo.ConfessionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConfessionService {

    private  final ConfessionRepo confessionRepo;

    public ConfessionDTO getConfessionById(UUID id) {
        Optional<PostEntity> confession = confessionRepo.findById(id);
        if(confession.isEmpty()) {
            return null;
        }
        PostEntity post = confession.get();
        ConfessionDTO confessionDTO = new ConfessionDTO();
        confessionDTO.setTitle(post.getTitle());
        confessionDTO.setContent(post.getContent());
        confessionDTO.setAuthor(post.getAuthor());
        System.out.println(confessionDTO);
        return confessionDTO;
    }


    public List<PostEntity> getAllConfessions(){
        return confessionRepo.findAll();
    }

}
