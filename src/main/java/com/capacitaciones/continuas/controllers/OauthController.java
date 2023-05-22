package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Persona;
import com.capacitaciones.continuas.Modelos.Primary.Rol;
import com.capacitaciones.continuas.Modelos.Primary.Usuario;
import com.capacitaciones.continuas.Security.Dtos.JwtDto;
import com.capacitaciones.continuas.Security.Dtos.LoginUser;
import com.capacitaciones.continuas.Security.Dtos.NewUser;
import com.capacitaciones.continuas.Security.JWT.JwtProvider;
import com.capacitaciones.continuas.Security.Models.Message;
import com.capacitaciones.continuas.services.PersonaService;
import com.capacitaciones.continuas.services.RolService;
import com.capacitaciones.continuas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class OauthController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService userService;

    @Autowired
    private RolService roleService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private JwtProvider jwtProvider;


   @GetMapping("/signIn/getaccount/{username}/{password}")
    public ResponseEntity<Usuario> login1(@PathVariable("username") String username, @PathVariable("password") String password) {
       try {
           Usuario usuario = usuarioService.findByUsernameAndPassword(username, password);
           if(usuario != null){
               return new ResponseEntity<>(usuario, HttpStatus.OK);
           }
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

       }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginUser loginUser, BindingResult bidBindingResult) {
        if (bidBindingResult.hasErrors()) {
            return new ResponseEntity<>(new Message("Revise sus credenciales"), HttpStatus.BAD_REQUEST);
        }
        try {

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Usuario usuario = userService.findByUsername(userDetails.getUsername());
            JwtDto jwtDto = new JwtDto(jwt, usuario);
            return ResponseEntity.ok(jwtDto);
        } catch (Exception e) {
            return new ResponseEntity<>(new Message("Revise sus credenciales" + e), HttpStatus.BAD_REQUEST);
        }
    }

    /*@PostMapping("/register")
    public ResponseEntity<Object> resgister(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("Revise los campos e intente nuevamente"), HttpStatus.BAD_REQUEST);
        Usuario user = new Usuario(newUser.getUsername(), passwordEncoder.encode(newUser.getPassword()) , newUser.getFotoPerfil(), newUser.getEstadoUsuarioActivo(), newUser.getPersona(), newUser.getRoles());
        user.setRoles(newUser.getRoles());
         List<Rol> roles = new ArrayList<>();
        for (Rol rol : newUser.getRoles()) {
            roles.add(roleService.findByNombreRol(rol.getNombreRol()));
        }
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity<>(new Message("Registro exitoso! Inicie sesión"), HttpStatus.CREATED);
    }*/

    @PostMapping("/register")
    public ResponseEntity<Usuario> crear(@RequestBody Usuario c) {
        try {
            c.setEstadoUsuarioActivo(true);
            c.setPassword(passwordEncoder.encode(c.getPassword()));
            return new ResponseEntity<>(usuarioService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/persona/crear")
    public ResponseEntity<Persona> crear(@RequestBody Persona c) {
        try {
            return new ResponseEntity<>(personaService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/existByCorreo/{email}")
    public ResponseEntity<?> existByCorreo(@PathVariable("email") String email) {
        try {
            Usuario usuario = userService.findByPersonaCorreo(email);
            if(usuario != null){
                return new ResponseEntity<>(usuario, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
