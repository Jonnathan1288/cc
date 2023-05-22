package com.capacitaciones.continuas.Security.Services;


import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import com.capacitaciones.continuas.Security.Models.UsuarioPrincipal;
import com.capacitaciones.continuas.services.UsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    private final UsuarioService userService;

    @Autowired
    public UserDetailsServiceImpl(UsuarioService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Usuario user = userService.findByUsername(userName);
        return UsuarioPrincipal.build(user);
    }
    
}
