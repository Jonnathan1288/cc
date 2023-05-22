package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.PeriodoPrograma;
import com.capacitaciones.continuas.services.PeriodoProgramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PeriodoProgramaController {
    @Autowired
    private PeriodoProgramaService periodoProgramaService;

    @GetMapping("/periodoPrograma/list")
    public ResponseEntity<List<PeriodoPrograma>> listperiodoPrograma(){
        try {
            return new ResponseEntity<>(periodoProgramaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/periodoPrograma/save")
    public ResponseEntity<PeriodoPrograma> savePeriodoPrograma(@RequestBody PeriodoPrograma pp){
        try {
            return new ResponseEntity<>(periodoProgramaService.save(pp), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/periodoPrograma/findbyId/{id}")
    public ResponseEntity<?> getPeriodoProgramaById(@PathVariable("id") Integer id){
        try {
            PeriodoPrograma nc = periodoProgramaService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("PERIODO PROGRAMA APROBADOS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/periodoPrograma/actualizar/{id}")
    public ResponseEntity<PeriodoPrograma> actualizarPeriodoPrograma(@PathVariable Integer id, @RequestBody PeriodoPrograma periodoPrograma) {
        try {
            if (periodoProgramaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            periodoPrograma.setNombrePeriodoPrograma(periodoPrograma.getNombrePeriodoPrograma());
            periodoPrograma.setFechaFinPeriodoPrograma(periodoPrograma.getFechaFinPeriodoPrograma());
            periodoPrograma.setFechaInicioPeriodoPrograma(periodoPrograma.getFechaInicioPeriodoPrograma());
            periodoPrograma.setEstadoPeriodoPrograma(periodoPrograma.getEstadoPeriodoPrograma());

            return new ResponseEntity<>(periodoProgramaService.save(periodoPrograma), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
