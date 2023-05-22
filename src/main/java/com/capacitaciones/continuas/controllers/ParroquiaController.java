package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.Modelos.Primary.Parroquia;
import com.capacitaciones.continuas.services.AreaService;
import com.capacitaciones.continuas.services.ParroquiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ParroquiaController {
    @Autowired
    private ParroquiaService parroquiaService;

    @GetMapping("/parroquia/list")
    public ResponseEntity<List<Parroquia>> listParroquia(){
        try {
            return new ResponseEntity<>(parroquiaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/parroquia/findbyId/{id}")
    public ResponseEntity<?> getParroquiaById(@PathVariable("id") Integer id){
        try {
            Parroquia parroquia = parroquiaService.findById(id);
            if(parroquia != null){
                return new ResponseEntity<>(parroquia, HttpStatus.OK);
            }
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/parroquia/findbyIdCanton/{id}")
    public ResponseEntity<List<Parroquia>> getParroquiaByIdCanton(@PathVariable("id") Integer id){
        try {
            List<Parroquia> parroquia = parroquiaService.findByCanton_IdCanton(id);
            if(parroquia != null){
                return new ResponseEntity<>(parroquia, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/parroquia/save")
    public ResponseEntity<Parroquia> saveParroquia(@RequestBody Parroquia parroquia){
        try {
            return new ResponseEntity<>(parroquiaService.save(parroquia), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/parroquia/actualizar/{id}")
    public ResponseEntity<Parroquia> actualizarParroquia(@PathVariable Integer id, @RequestBody Parroquia parroquia) {
        try {
            if (parroquiaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            parroquia.setParroquia(parroquia.getParroquia());
            parroquia.setCanton(parroquia.getCanton());
            return new ResponseEntity<>(parroquiaService.save(parroquia), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
