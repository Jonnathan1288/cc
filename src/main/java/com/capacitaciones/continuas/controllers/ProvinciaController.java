package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Parroquia;
import com.capacitaciones.continuas.Modelos.Primary.Provincia;
import com.capacitaciones.continuas.services.ParroquiaService;
import com.capacitaciones.continuas.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ProvinciaController {
    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("/provincia/list")
    public ResponseEntity<List<Provincia>> listProvincia(){
        try {
            return new ResponseEntity<>(provinciaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/provincia/findbyId/{id}")
    public ResponseEntity<?> getProvinciaById(@PathVariable("id") Integer id){
        try {
            Provincia provincia = provinciaService.findById(id);
            if(provincia != null){
                return new ResponseEntity<>(provincia, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/provincia/save")
    public ResponseEntity<Provincia> saveProvincia(@RequestBody Provincia provincia){
        try {
            return new ResponseEntity<>(provinciaService.save(provincia), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/provincia/actualizar/{id}")
    public ResponseEntity<Provincia> actualizarProvincia(@PathVariable Integer id, @RequestBody Provincia provincia) {
        try {
            if (provinciaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            provincia.setProvincia(provincia.getProvincia());

            return new ResponseEntity<>(provinciaService.save(provincia), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
