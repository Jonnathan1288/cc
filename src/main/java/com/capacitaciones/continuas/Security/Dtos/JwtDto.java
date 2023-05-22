
package com.capacitaciones.continuas.Security.Dtos;

import com.capacitaciones.continuas.Modelos.Primary.Usuario;

public class JwtDto {
    private String token;
    private Usuario user;

    public JwtDto(String token, Usuario user) {
        this.token = token;
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
