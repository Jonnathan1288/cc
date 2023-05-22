package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Especialidad;
import com.capacitaciones.continuas.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EspecialidadController {
    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping("/especialidad/list")
    public ResponseEntity<List<Especialidad>> listEspecialidad(){
        try {
            return new ResponseEntity<>(especialidadService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/especialidad/findbyId/{id}")
    public ResponseEntity<?> getespecialidadById(@PathVariable("id") Integer id){
        try {
            Especialidad dc = especialidadService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("especialidad NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/especialidad/findbyIdArea/{id}")
    public ResponseEntity<List<Especialidad>> getespecialidadByIdArea(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(especialidadService.findByAreaIdArea(id),HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/especialidad/save")
    public ResponseEntity<Especialidad> saveEspecialidad(@RequestBody Especialidad especialidad){
        try {
            return new ResponseEntity<>(especialidadService.save(especialidad), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/especialidad/update/{id}")
    public ResponseEntity<Especialidad> actualizarEspecialidad(@PathVariable Integer id, @RequestBody Especialidad especialidad) {
        try {
            if (especialidadService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            especialidad.setCodigoEspecialidad(especialidad.getCodigoEspecialidad());
            especialidad.setNombreEspecialidad(especialidad.getNombreEspecialidad());
            especialidad.setEstadoEspecialidadActivo(especialidad.getEstadoEspecialidadActivo());
            especialidad.setArea(especialidad.getArea());
            Especialidad newObject = especialidadService.save(especialidad);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
