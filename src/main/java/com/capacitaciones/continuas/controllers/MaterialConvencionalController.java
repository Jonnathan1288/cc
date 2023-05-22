package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.MaterialConvencional;
import com.capacitaciones.continuas.services.MaterialConvencionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MaterialConvencionalController {
    @Autowired
    private MaterialConvencionalService materialConvencionalService;

    @GetMapping("/materialConvencional/list")
    public ResponseEntity<List<MaterialConvencional>> listMaterialConvencional(){
        try {
            return new ResponseEntity<>(materialConvencionalService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/materialConvencional/save")
    public ResponseEntity<MaterialConvencional> saveMaterialConvencional(@RequestBody MaterialConvencional materialConvencional){
        try {
            return new ResponseEntity<>(materialConvencionalService.save(materialConvencional), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/materialConvencional/findbyId/{id}")
    public ResponseEntity<?> getMaterialConvencionalById(@PathVariable("id") Integer id){
        try {
            MaterialConvencional materialConvencional = materialConvencionalService.findById(id);
            if(materialConvencional != null){
                return new ResponseEntity<>(materialConvencional, HttpStatus.OK);
            }
            return new ResponseEntity<>("CAPACITADOR NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/materialConvencionalPorSilabo/findbyId/{IdSilabo}")
    public ResponseEntity<?> getResultadosPorSilabo(@PathVariable("IdSilabo") Integer IdSilabo){
        try {
            List<MaterialConvencional> nc = materialConvencionalService.findBySilaboIdSilabo(IdSilabo);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/materialConvencional/actualizar/{id}")
    public ResponseEntity<MaterialConvencional> actualizarMaterialConvencional(@PathVariable Integer id, @RequestBody MaterialConvencional materialConvencional) {
        try {
            if (materialConvencionalService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            materialConvencional.setDescripcionMaterialConvencional(materialConvencional.getDescripcionMaterialConvencional());
            materialConvencional.setEstadoMaterialConvencional(materialConvencional.getEstadoMaterialConvencional());
            return new ResponseEntity<>(materialConvencionalService.save(materialConvencional), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
