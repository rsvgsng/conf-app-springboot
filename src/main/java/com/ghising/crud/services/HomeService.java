package com.ghising.crud.services;
import com.ghising.crud.entity.UserEntity;
import com.ghising.crud.repo.ConfessionRepo;
import com.ghising.crud.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HomeService {

    private  final ConfessionRepo confessionRepo;
    private  final UserRepo userRepo;

    public  Optional<UserEntity> showHome(String username, String password) {

        Optional<UserEntity> user = userRepo.findByUsername(username);
        if(user.isPresent()){
            System.out.println("User found: " + user.get());
        } else {
            System.out.println("User not found");
        }


        return  user;
    }




}
