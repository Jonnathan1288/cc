package com.capacitaciones.continuas.Security.Dtos;

import com.capacitaciones.continuas.Modelos.Primary.Persona;
import com.capacitaciones.continuas.Modelos.Primary.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
public class NewUser {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String fotoPerfil;

    private Boolean estadoUsuarioActivo;

    private Persona persona;

    private List<Rol> roles;


    
}
