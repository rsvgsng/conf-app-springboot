package com.ghising.crud.services;

import com.ghising.crud.entity.UserEntity;
import com.ghising.crud.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthService {

    private  final UserRepo userRepo;

    public  UserEntity login(String username, String password) {
        return userRepo.findByUsername(username)
                .map(user -> {
                    if (user.getPassword().equals(password)) {
                        System.out.println("User found: " + user);
                        return user;
                    } else {
                        System.out.println("Invalid password");
                        throw new RuntimeException("Invalid password");
                    }
                })
                .orElseThrow(() -> {
                    System.out.println("User not found");
                    return new RuntimeException("User not found");
                });

    }

    public  UserEntity register(String name, String username, String password) {
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setCreatedAt(new Date());
        return userRepo.save(user);
    }

}
