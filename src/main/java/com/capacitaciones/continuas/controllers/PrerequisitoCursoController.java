package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.PrerequisitoCurso;
import com.capacitaciones.continuas.services.PrerequisitoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PrerequisitoCursoController {
    @Autowired
    private PrerequisitoCursoService prerequisitoCursoService;

    @GetMapping("/prerequisitoCurso/list")
    public ResponseEntity<List<PrerequisitoCurso>> listPrerequisitoCurso(){
        try {
            return new ResponseEntity<>(prerequisitoCursoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/prerequisitoCurso/findbyId/{id}")
    public ResponseEntity<?> getPrerequisitoCursoById(@PathVariable("id") Integer id){
        try {
            PrerequisitoCurso pr = prerequisitoCursoService.findById(id);
            if(pr != null){
                return new ResponseEntity<>(pr, HttpStatus.OK);
            }
            return new ResponseEntity<>("PREREQUISITO NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/prerequisitoCurso/findbyIdCurso/{id}")
    public ResponseEntity<?> getPrerequisitoCursoByIdCurso(@PathVariable("id") Integer id){
        try {
            List<PrerequisitoCurso> pr = prerequisitoCursoService.findByCursoIdCurso(id);
            if(pr != null){
                return new ResponseEntity<>(pr, HttpStatus.OK);
            }
            return new ResponseEntity<>("PREREQUISITO DEL CURSO NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/prerequisitoCurso/save")
    public ResponseEntity<PrerequisitoCurso> savePrerequisitoCurso(@RequestBody PrerequisitoCurso df){
        try {
            return new ResponseEntity<>(prerequisitoCursoService.save(df), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/prerequisitoCurso/actualizar/{id}")
    public ResponseEntity<PrerequisitoCurso> actualizarPrerequisitoCurso(@PathVariable Integer id, @RequestBody PrerequisitoCurso prerequisitoCurso) {
        try {
            if (prerequisitoCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            prerequisitoCurso.setNombrePrerequisitoCurso(prerequisitoCurso.getNombrePrerequisitoCurso());
            prerequisitoCurso.setEstadoPrerequisitoCurso(prerequisitoCurso.getEstadoPrerequisitoCurso());
            return new ResponseEntity<>(prerequisitoCursoService.save(prerequisitoCurso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
