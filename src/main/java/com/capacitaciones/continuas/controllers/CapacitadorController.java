package com.capacitaciones.continuas.controllers;


import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.services.CapacitadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CapacitadorController {
    @Autowired
    private CapacitadorService capacitadorService;

    @GetMapping("/capacitador/list")
    public ResponseEntity<List<Capacitador>> listCapacitador(){
        try {
            return new ResponseEntity<>(capacitadorService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/capacitador/findbyId/{id}")
    public ResponseEntity<?> getCapacitadorById(@PathVariable("id") Integer id){
        try {
            Capacitador capacitador = capacitadorService.findById(id);
            if(capacitador != null){
                return new ResponseEntity<>(capacitador, HttpStatus.OK);
            }
            return new ResponseEntity<>("CAPACITADOR NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/capacitador/exists/findbyIdUsuario/{idUsuario}")
    public Boolean getCapacitadorExistsByIdUsuario(@PathVariable("idUsuario") Integer idUsuario){
        try {
            if(capacitadorService.existsByUsuarioIdUsuario(idUsuario)){
                return true;
            }
            return false;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/capacitador/findbyIdUsuario/{id}")
    public ResponseEntity<?> findByUsuarioIdUsuario(@PathVariable("id") Integer id){
        try {
            Capacitador capacitador = capacitadorService.findByUsuarioIdUsuario(id);
            if(capacitador != null){
                return new ResponseEntity<>(capacitador, HttpStatus.OK);
            }
            return new ResponseEntity<>("CAPACITADOR NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/capacitador/save")
    public ResponseEntity<Capacitador> saveCapacitador(@RequestBody Capacitador capacitador){
        try {
            return new ResponseEntity<>(capacitadorService.save(capacitador), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/capacitador/actualizar/{id}")
    public ResponseEntity<Capacitador> actualizarCapacitador(@PathVariable Integer id, @RequestBody Capacitador capacitador) {
        try {
            if (capacitadorService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            capacitador.setTituloCapacitador(capacitador.getTituloCapacitador());
            capacitador.setTipoAbreviaturaTitulo(capacitador.getTipoAbreviaturaTitulo());
            capacitador.setEstadoActivoCapacitador(capacitador.getEstadoActivoCapacitador());
            Capacitador newObject = capacitadorService.save(capacitador);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
