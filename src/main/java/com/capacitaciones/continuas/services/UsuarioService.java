package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Usuario;

public interface UsuarioService extends GenericService<Usuario,Integer>{
    public Usuario findByUsernameAndPassword(String username, String password);

    public Usuario findByTokenPassword(String tokenPassword);

    public Boolean existsByUsername(String username);

    Usuario findByUsername(String username);

    public Usuario findByPersonaCorreo(String correo);

    Usuario findByPersonaIdentificacion(String cedula);

    public Boolean existsByPersonaCorreo(String email);

}
