package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Notas;
import com.capacitaciones.continuas.services.NotasSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class NotasController {

    @Autowired
    NotasSevice notasSevice;

    @GetMapping("/notas/listar")
    public ResponseEntity<List<Notas>> obtenerLista() {
        try {
        return new ResponseEntity<>(notasSevice.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/notas/findbyId/{id}")
    public ResponseEntity<?> getNotasById(@PathVariable("id") Integer id){
        try {
            Notas nc = notasSevice.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOTAS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/validarExistenciNotas/findbyIdCurso/{id}")
    public boolean validarExistenciNotas(@PathVariable("id") Integer id){
        return notasSevice.validarExistenciaDeRegistroNotas(id);
    }

    @GetMapping("/notas/findbyIdMatriculado/{idCurso}")
    public ResponseEntity<?> getNotasfindbyIdMatriculado(@PathVariable("idCurso") Integer idCurso){
        try {
            List<Notas> nc = notasSevice.findByPartipantesMatriculadosInscritoCursoIdCurso(idCurso);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOTAS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/notas/findbyIdParticipantesFinales/{idParticipantesFinales}")
    public ResponseEntity<?> getNotasParticipantesFinales(@PathVariable("idParticipantesFinales") Integer idParticipantesFinales){
        try {
            List<Notas> nc = notasSevice.findByPartipantesMatriculadosIdParticipanteMatriculado(idParticipantesFinales);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOTAS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/notas/crear")
    public ResponseEntity<Notas> crear(@RequestBody Notas c) {
        try {
        return new ResponseEntity<>(notasSevice.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/notas/actualizar/{id}")
    public ResponseEntity<Notas> actualizarNotas(@PathVariable Integer id, @RequestBody Notas notas) {
        try {
            if (notasSevice.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            notas.setParcial(notas.getParcial());
            notas.setExamenFinal(notas.getExamenFinal());
            notas.setObservacion(notas.getObservacion());

            return new ResponseEntity<>(notasSevice.save(notas), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
