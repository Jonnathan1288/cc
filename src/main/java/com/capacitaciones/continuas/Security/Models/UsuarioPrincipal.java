package com.capacitaciones.continuas.Security.Models;

import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
public class UsuarioPrincipal implements UserDetails {

    // ESTA CLASE SIRVE PARA PODER CONTROLAR LOS ROLES DE CADA USUARIO Y DAR LOS RESPECTIVOS PERMISOS

    private int idUsuario;
    private String username;
    private String password;
    private String fotoUsuario;
    private Boolean estadoUsuario;
    private Collection<? extends GrantedAuthority> authorities;


    public static UsuarioPrincipal build(Usuario user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getNombreRol())).collect(Collectors.toList());
        return new UsuarioPrincipal(
                user.getIdUsuario(),
                user.getUsername(),
                user.getPassword(),
                user.getFotoPerfil(),
                user.getEstadoUsuarioActivo(),
                authorities);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    
}
