package com.capacitaciones.continuas.controllers;


import com.capacitaciones.continuas.Modelos.Primary.InformeFinalCurso;
import com.capacitaciones.continuas.services.InformeFinalCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class InformeFinalCursoController {

    @Autowired
    InformeFinalCursoService informeFinalCursoService;

    @GetMapping("/informeFinalCurso/listar")
    public ResponseEntity<List<InformeFinalCurso>> obtenerLista() {
        try {
            return new ResponseEntity<>(informeFinalCursoService.findByAll(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/informeFinalCurso/findbyId/{id}")
    public ResponseEntity<?> getInformeFinalCursoById(@PathVariable("id") Integer id){
        try {
            InformeFinalCurso dc = informeFinalCursoService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("informeFinalCurso NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/informeFinalCurso/crear")
    public ResponseEntity<InformeFinalCurso> crear(@RequestBody InformeFinalCurso c) {
        try {
            return new ResponseEntity<>(informeFinalCursoService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/informeFinalCurso/update/{id}")
    public ResponseEntity<InformeFinalCurso> actualizarInformeFinalCurso(@PathVariable Integer id, @RequestBody InformeFinalCurso infofinalc) {
        try {
            if (informeFinalCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            infofinalc.setObservacionesInformeFinalCurso(infofinalc.getObservacionesInformeFinalCurso());
            infofinalc.setLugarInformeFinalCurso(infofinalc.getLugarInformeFinalCurso());
            infofinalc.setNombreCantonInformeFinalCurso(infofinalc.getNombreCantonInformeFinalCurso());
            infofinalc.setCurso(infofinalc.getCurso());
            InformeFinalCurso newObject = informeFinalCursoService.save(infofinalc);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/informeFinalCurso/findbyIdCurso/{id}")
    public ResponseEntity<?> getInformeFinalCursoByIdCurso(@PathVariable("id") Integer id){
        try {
            InformeFinalCurso info = informeFinalCursoService.findByCursoIdCurso(id);
            if(info != null){
                return new ResponseEntity<>(info, HttpStatus.OK);
            }
            return new ResponseEntity<>("INFORM NOT FOUND",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
