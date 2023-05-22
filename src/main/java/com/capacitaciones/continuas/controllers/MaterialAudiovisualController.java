package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.MaterialAudiovisual;
import com.capacitaciones.continuas.services.MaterialAudiovisualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class MaterialAudiovisualController {
    @Autowired
    private MaterialAudiovisualService materialAudiovisualService;

    @GetMapping("/materialAudiovisual/list")
    public ResponseEntity<List<MaterialAudiovisual>> listMaterialAudiovisual(){
        try {
            return new ResponseEntity<>(materialAudiovisualService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/materialAudiovisual/save")
    public ResponseEntity<MaterialAudiovisual> saveMaterialAudiovisual(@RequestBody MaterialAudiovisual materialAudiovisual){
        try {
            return new ResponseEntity<>(materialAudiovisualService.save(materialAudiovisual), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/materialAudiovisual/findbyId/{id}")
    public ResponseEntity<?> getMaterialAudiovisualById(@PathVariable("id") Integer id){
        try {
            MaterialAudiovisual materialConvencional = materialAudiovisualService.findById(id);
            if(materialConvencional != null){
                return new ResponseEntity<>(materialConvencional, HttpStatus.OK);
            }
            return new ResponseEntity<>("CAPACITADOR NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/materialAudiovisualPorSilabo/findbyId/{IdSilabo}")
    public ResponseEntity<?> getResultadosPorSilabo(@PathVariable("IdSilabo") Integer IdSilabo){
        try {
            List<MaterialAudiovisual> nc = materialAudiovisualService.findBySilaboIdSilabo(IdSilabo);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/materialAudiovisual/actualizar/{id}")
    public ResponseEntity<MaterialAudiovisual> actualizarMaterialAudiovisual(@PathVariable Integer id, @RequestBody MaterialAudiovisual materialAudiovisual) {
        try {
            if (materialAudiovisualService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            materialAudiovisual.setDescripcionMaterialAudiovisual(materialAudiovisual.getDescripcionMaterialAudiovisual());
            materialAudiovisual.setEstadoMaterialAudiovisual(materialAudiovisual.getEstadoMaterialAudiovisual());
            return new ResponseEntity<>(materialAudiovisualService.save(materialAudiovisual), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
