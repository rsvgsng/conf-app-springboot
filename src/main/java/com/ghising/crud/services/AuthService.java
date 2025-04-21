package com.ghising.crud.services;

import com.ghising.crud.entity.UserEntity;
import com.ghising.crud.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@AllArgsConstructor
@Service
public class AuthService {

    private  final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private  final PasswordEncoder passwordEncoder;

    public  void login(String username, String password) {
        System.out.println(username+" "+password);
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password)
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public  UserEntity register(String name, String username, String password) {
        if(userRepo.findByUsername(username).isPresent()){
            throw new RuntimeException("User already exists");
        }
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setCreatedAt(new Date());
        return userRepo.save(user);
    }

}
