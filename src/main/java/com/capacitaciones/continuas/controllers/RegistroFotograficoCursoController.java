package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.RegistroFotograficoCurso;
import com.capacitaciones.continuas.services.RegistroFotograficoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class RegistroFotograficoCursoController {

    @Autowired
    RegistroFotograficoCursoService registroFotograficoCursoService;

    @GetMapping("/registroFotograficoCurso/listar")
    public ResponseEntity<List<RegistroFotograficoCurso>> obtenerLista() {
        try {
        return new ResponseEntity<>(registroFotograficoCursoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/registroFotograficoCurso/crear")
    public ResponseEntity<RegistroFotograficoCurso> crear(@RequestBody RegistroFotograficoCurso c) {
        try {
            c.setEstado(true);
            return new ResponseEntity<>(registroFotograficoCursoService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/registroFotograficoCurso/findbyId/{id}")
    public ResponseEntity<?> getRegistroFotograficoCursoById(@PathVariable("id") Integer id){
        try {
            RegistroFotograficoCurso nc = registroFotograficoCursoService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("REGIS FOTOGRAFICO NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/registroFotograficoCurso/traerTodosfindbyIdCurso/{idCurso}")
    public ResponseEntity<?> getRegistroFotograficoCursoAllByIdCurso(@PathVariable("idCurso") Integer idCurso){
        try {
            List<RegistroFotograficoCurso> registroFotograficoCursoList = registroFotograficoCursoService.findByCursoIdCurso(idCurso);
            if(registroFotograficoCursoList != null){
                return new ResponseEntity<>(registroFotograficoCursoList, HttpStatus.OK);
            }
            return new ResponseEntity<>("FOTOGRAFIAS NO ENCONTRADAS",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/registroFotograficoCurso/actualizar/{id}")
    public ResponseEntity<RegistroFotograficoCurso> actualizarRegistroFotograficoCurso(@PathVariable Integer id, @RequestBody RegistroFotograficoCurso registroFotograficoCurso) {
        try {
            if (registroFotograficoCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            registroFotograficoCurso.setFoto(registroFotograficoCurso.getFoto());
            registroFotograficoCurso.setDescripcionFoto(registroFotograficoCurso.getDescripcionFoto());
            registroFotograficoCurso.setFecha(registroFotograficoCurso.getFecha());
            registroFotograficoCurso.setEstado(registroFotograficoCurso.getEstado());
            return new ResponseEntity<>(registroFotograficoCursoService.save(registroFotograficoCurso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
