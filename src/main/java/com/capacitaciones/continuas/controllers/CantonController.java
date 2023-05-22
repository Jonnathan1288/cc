package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Canton;
import com.capacitaciones.continuas.Modelos.Primary.Parroquia;
import com.capacitaciones.continuas.services.CantonService;
import com.capacitaciones.continuas.services.ParroquiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CantonController {
    @Autowired
    private CantonService cantonService;

    @GetMapping("/canton/list")
    public ResponseEntity<List<Canton>> listCanton(){
        try {
            return new ResponseEntity<>(cantonService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/canton/findbyId/{id}")
    public ResponseEntity<?> getCantonById(@PathVariable("id") Integer id){
        try {
            Canton canton = cantonService.findById(id);
            if(canton != null){
                return new ResponseEntity<>(canton, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/canton/findbyIdProvincia/{id}")
    public ResponseEntity<List<Canton>> getCantonByIdProvincia(@PathVariable("id") Integer id){
        try {
            List<Canton> canton = cantonService.findByProvinciaIdProvincia(id);
            if(canton != null){
                return new ResponseEntity<>(canton, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/canton/save")
    public ResponseEntity<Canton> saveParroquia(@RequestBody Canton canton){
        try {
            return new ResponseEntity<>(cantonService.save(canton), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/canton/actualizar/{id}")
    public ResponseEntity<Canton> actualizarParroquia(@PathVariable Integer id, @RequestBody Canton canton) {
        try {
            if (cantonService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            canton.setCanton(canton.getCanton());
            return new ResponseEntity<>(cantonService.save(canton), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
