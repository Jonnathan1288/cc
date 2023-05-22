package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Persona;
import com.capacitaciones.continuas.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/persona/listar")
    public ResponseEntity<List<Persona>> obtenerLista() {
        try {
            return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/persona/findbyId/{id}")
    public ResponseEntity<?> getPersonaById(@PathVariable("id") Integer id){
        try {
            Persona nc = personaService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("PERSONA APROBADOS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PutMapping("/persona/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Integer id, @RequestBody Persona persona) {
        try {
            if (personaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            persona.setNombre1(persona.getNombre1());
            persona.setNombre2(persona.getNombre2());
            persona.setApellido1(persona.getApellido1());
            persona.setApellido2(persona.getApellido2());
            persona.setFechaNacimiento(persona.getFechaNacimiento());
            persona.setTelefono(persona.getTelefono());
            persona.setCelular(persona.getCelular());
            persona.setCorreo(persona.getCorreo());
            persona.setGenero(persona.getGenero());
            persona.setEtnia(persona.getEtnia());

            return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
