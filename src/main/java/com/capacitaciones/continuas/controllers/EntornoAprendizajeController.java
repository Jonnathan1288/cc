package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.EntornoAprendizajeCurricular;
import com.capacitaciones.continuas.services.EntornoAprendizajeCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EntornoAprendizajeController {
    @Autowired
    private EntornoAprendizajeCurricularService entornoAprendizajeCurricularService;

    @GetMapping("/entornoAprendizajeCurricular/list")
    public ResponseEntity<List<EntornoAprendizajeCurricular>> listDisenioCurricular(){
        try {
            return new ResponseEntity<>(entornoAprendizajeCurricularService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/entornoAprendizajeCurricular/findbyId/{id}")
    public ResponseEntity<?> getEntornoAprendizajeCurricularById(@PathVariable("id") Integer id){
        try {
            EntornoAprendizajeCurricular dc = entornoAprendizajeCurricularService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("entornoAprendizajeCurricular NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/entornoAprendizajeCurricular/save")
    public ResponseEntity<EntornoAprendizajeCurricular> saveDisenioCurricular(@RequestBody EntornoAprendizajeCurricular entornoAprendizajeCurricular){
        try {
            return new ResponseEntity<>(entornoAprendizajeCurricularService.save(entornoAprendizajeCurricular), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/entornoAprendizajeCurricular/update/{id}")
    public ResponseEntity<EntornoAprendizajeCurricular> actualizarEntornoAprendizajeCurricular(@PathVariable Integer id, @RequestBody EntornoAprendizajeCurricular enapc) {
        try {
            if (entornoAprendizajeCurricularService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            enapc.setInstalaciones(enapc.getInstalaciones());
            enapc.setFaseTeorica(enapc.getFaseTeorica());
            enapc.setFasePractica(enapc.getFasePractica());
            enapc.setDisenioCurricular(enapc.getDisenioCurricular());
            enapc.setEstadoEntornoAprendizaje(enapc.getEstadoEntornoAprendizaje());
            EntornoAprendizajeCurricular newObject = entornoAprendizajeCurricularService.save(enapc);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Metodo

    @GetMapping("/entornoAprendizajeporDisenioCurricular/findbyId/{idDisenioCurricular}")
    public ResponseEntity<?> getEntornoAprendizajePorDisenioCurricular(@PathVariable("idDisenioCurricular") Integer idDisenioCurricular){
        try {
            List<EntornoAprendizajeCurricular> nc = entornoAprendizajeCurricularService.findByDisenioCurricularIdDisenioCurricular(idDisenioCurricular);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
