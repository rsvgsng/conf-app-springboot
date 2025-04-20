package com.ghising.crud.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class SignupDto {

    @NotBlank(message = "Your name is required.")
    @Length( min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Length( min = 3, max = 50, message = "Username must be between 3 and 50 characters.xx")
    @NotBlank(message = "Username is required.")
    private String username;

    @Length( min = 6, max = 50, message = "Password must be between 6 and 50 characters.")
    @NotBlank(message = "Password is required.")
    private String password;
}
