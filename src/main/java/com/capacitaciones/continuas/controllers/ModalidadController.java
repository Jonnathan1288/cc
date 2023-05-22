package com.capacitaciones.continuas.controllers;


import com.capacitaciones.continuas.Modelos.Primary.ModalidadCurso;
import com.capacitaciones.continuas.services.ModalidadCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ModalidadController {
    @Autowired
    private ModalidadCursoService modalidadCursoService;

    @GetMapping("/modalidadCurso/list")
    public ResponseEntity<List<ModalidadCurso>> listModalidad(){
        try {
            return new ResponseEntity<>(modalidadCursoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/modalidadCurso/findbyId/{id}")
    public ResponseEntity<?> getModalidadById(@PathVariable("id") Integer id){
        try {
            ModalidadCurso mc = modalidadCursoService.findById(id);
            if(mc != null){
                return new ResponseEntity<>(mc, HttpStatus.OK);
            }
            return new ResponseEntity<>("MODALIDAD NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/modalidadCurso/save")
    public ResponseEntity<ModalidadCurso> saveModalidad(@RequestBody ModalidadCurso mc){
        try {
            return new ResponseEntity<>(modalidadCursoService.save(mc), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/modalidadCurso/actualizar/{id}")
    public ResponseEntity<ModalidadCurso> actualizarMaterialConvencional(@PathVariable Integer id, @RequestBody ModalidadCurso modalidadCurso) {
        try {
            if (modalidadCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            modalidadCurso.setNombreModalidadCurso(modalidadCurso.getNombreModalidadCurso());
            modalidadCurso.setEstadoModalidadCurso(modalidadCurso.getEstadoModalidadCurso());
            return new ResponseEntity<>(modalidadCursoService.save(modalidadCurso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
