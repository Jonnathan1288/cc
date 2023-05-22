package com.capacitaciones.continuas.Security.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
public class LoginUser {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    
}
