package com.ghising.crud.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginDTO {

    @NotBlank(message = "Username is required")
    private  String username;

    @NotBlank(message = "Password is required")
    private  String password;
}
