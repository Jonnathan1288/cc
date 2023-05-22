package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.NivelCurso;
import com.capacitaciones.continuas.services.NivelCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class NivelCursoController {
    @Autowired
    private NivelCursoService nivelCursoService;

    @GetMapping("/nivelCurso/list")
    public ResponseEntity<List<NivelCurso>> listNivelCurso(){
        try {
            return new ResponseEntity<>(nivelCursoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nivelCurso/findbyId/{id}")
    public ResponseEntity<?> getNivelCursoById(@PathVariable("id") Integer id){
        try {
            NivelCurso nc = nivelCursoService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NIVEL CURSO NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/nivelCurso/save")
    public ResponseEntity<NivelCurso> saveNivelCurso(@RequestBody NivelCurso df){
        try {
            return new ResponseEntity<>(nivelCursoService.save(df), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/nivelCurso/actualizar/{id}")
    public ResponseEntity<NivelCurso> actualizarNivelCurso(@PathVariable Integer id, @RequestBody NivelCurso nivelCurso) {
        try {
            if (nivelCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            nivelCurso.setNombreNivelCurso(nivelCurso.getNombreNivelCurso());
            nivelCurso.setEstadoNivelCurso(nivelCurso.getEstadoNivelCurso());

            return new ResponseEntity<>(nivelCursoService.save(nivelCurso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
