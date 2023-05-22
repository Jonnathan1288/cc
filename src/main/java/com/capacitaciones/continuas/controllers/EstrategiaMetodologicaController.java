package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.EstrategiasMetodologica;
import com.capacitaciones.continuas.services.EstrategiaMetodologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EstrategiaMetodologicaController {
    @Autowired
    private EstrategiaMetodologicaService estrategiaMetodologicaService;

    @GetMapping("/estrategiaMetodologica/list")
    public ResponseEntity<List<EstrategiasMetodologica>> listEstrategiaMetodologica(){
        try {
            return new ResponseEntity<>(estrategiaMetodologicaService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/estrategiaMetodologica/findbyId/{id}")
    public ResponseEntity<?> getEstrategiaMetodologicaById(@PathVariable("id") Integer id){
        try {
            EstrategiasMetodologica dc = estrategiaMetodologicaService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("estrategiaMetodologica NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/strategiaMetodologica/save")
    public ResponseEntity<EstrategiasMetodologica> saveEstrategiaMetodologica(@RequestBody EstrategiasMetodologica estrategiasMetodologica){
        try {
            return new ResponseEntity<>(estrategiaMetodologicaService.save(estrategiasMetodologica), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/strategiaMetodologicaPorSilabo/findbyId/{IdSilabo}")
    public ResponseEntity<?> getResultadosPorSilabo(@PathVariable("IdSilabo") Integer IdSilabo){
        try {
            List<EstrategiasMetodologica> nc = estrategiaMetodologicaService.findBySilaboIdSilabo(IdSilabo);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/strategiaMetodologica/update/{id}")
    public ResponseEntity<EstrategiasMetodologica> actualizarEspecialidad(@PathVariable Integer id, @RequestBody EstrategiasMetodologica estrategism) {
        try {
            if (estrategiaMetodologicaService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            estrategism.setNombreEstrategiaMetodologica(estrategism.getNombreEstrategiaMetodologica());
            estrategism.setFinalidadEstrategiaMetodologica(estrategism.getFinalidadEstrategiaMetodologica());
            estrategism.setSilabo(estrategism.getSilabo());

            EstrategiasMetodologica newObject = estrategiaMetodologicaService.save(estrategism);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
