package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "foto_perfil", columnDefinition = "LONGBLOB")
    private String fotoPerfil;  // igamen para la base de datos

    @Column(name = "estado_usuario_activo", columnDefinition = "BOOLEAN")
    private Boolean estadoUsuarioActivo;

    @Column(name = "token_password", length = 1800)
    private String tokenPassword;

    // RELACIONES
    @ManyToOne
    @JoinColumn(name="id_persona",referencedColumnName ="id_persona")
    private Persona persona;


    /*@ManyToOne
    @JoinColumn(name="id_rol",referencedColumnName ="id_rol")
    private Rol rol;*/



    //RELACION DE MUCHOS A MUCHOS

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private List<Rol> roles;


    public Usuario(String username, String password, String fotoPerfil, Boolean estadoUsuarioActivo, Persona persona) {
        this.username = username;
        this.password = password;
        this.fotoPerfil = fotoPerfil;
        this.estadoUsuarioActivo = estadoUsuarioActivo;
        this.persona = persona;
    }

    public Usuario(String username, String password, String fotoPerfil, Boolean estadoUsuarioActivo,  Persona persona, List<Rol> roles) {
        this.username = username;
        this.password = password;
        this.fotoPerfil = fotoPerfil;
        this.estadoUsuarioActivo = estadoUsuarioActivo;
        this.persona = persona;
        this.roles = roles;
    }

    public Usuario(){}


}
