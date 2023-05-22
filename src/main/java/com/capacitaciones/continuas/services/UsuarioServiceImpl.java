package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import com.capacitaciones.continuas.repositorys.Primarys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, Integer> implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public CrudRepository<Usuario, Integer> getDao() {
        return usuarioRepository;
    }

    @Override
    public Usuario findByUsernameAndPassword(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Usuario findByTokenPassword(String tokenPassword) {
        return usuarioRepository.findByTokenPassword(tokenPassword);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario findByPersonaCorreo(String correo) {
        return usuarioRepository.findByPersonaCorreo(correo);
    }

    @Override
    public Usuario findByPersonaIdentificacion(String cedula) {
        return usuarioRepository.findByPersonaIdentificacion(cedula);
    }

    @Override
    public Boolean existsByPersonaCorreo(String email) {
        return usuarioRepository.existsByPersonaCorreo(email);
    }
}

