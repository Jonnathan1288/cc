package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Programas;
import com.capacitaciones.continuas.services.ProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProgramasController {

    @Autowired
    ProgramaService programaService;

    @GetMapping("/programa/listar")
    public ResponseEntity<List<Programas>> obtenerLista() {
        try {
            return new ResponseEntity<>(programaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/programa/findbyId/{id}")
    public ResponseEntity<?> getProgramaById(@PathVariable("id") Integer id){
        try {
            Programas programas = programaService.findById(id);
            if(programas != null){
                return new ResponseEntity<>(programas, HttpStatus.OK);
            }
            return new ResponseEntity<>("PROGRAMA NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/programa/crear")
    public ResponseEntity<Programas> crear(@RequestBody Programas c) {
        try {
            return new ResponseEntity<>(programaService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/programa/actualizar/{id}")
    public ResponseEntity<Programas> actualizarProgramas(@PathVariable Integer id, @RequestBody Programas programas) {
        try {
            if (programaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            programas.setNombrePrograma(programas.getNombrePrograma());
            programas.setDescripcionPrograma(programas.getDescripcionPrograma());
            programas.setEstadoProgramaActivo(programas.getEstadoProgramaActivo());
            return new ResponseEntity<>(programaService.save(programas), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
