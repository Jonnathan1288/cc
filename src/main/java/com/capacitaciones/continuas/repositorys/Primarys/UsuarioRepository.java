package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findByUsernameAndPassword(String username, String password);

    public Boolean existsByUsername(String username);


    public Usuario findByTokenPassword(String tokenPassword);

    Usuario findByUsername(String username);

    Usuario findByPersonaIdentificacion(String cedula);

    public Usuario findByPersonaCorreo(String correo);

    public Boolean existsByPersonaCorreo(String email);

}
