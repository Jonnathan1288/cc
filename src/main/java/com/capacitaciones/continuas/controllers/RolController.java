package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Rol;
import com.capacitaciones.continuas.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/rol/listar")
    public ResponseEntity<List<Rol>> obtenerLista() {
        try {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/rol/crear")
    public ResponseEntity<Rol> crear(@RequestBody Rol c) {
        try {
        return new ResponseEntity<>(rolService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/rol/actualizar/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol rol) {
        try {
            if (rolService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            rol.setNombreRol(rol.getNombreRol());
            rol.setEstadoRolActivo(rol.getEstadoRolActivo());
            return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
