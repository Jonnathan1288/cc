package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.EvalucionFormativaCurricular;
import com.capacitaciones.continuas.services.EvaluacionFormativaCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EvaluacionFormativaCurricularController {
    @Autowired
    private EvaluacionFormativaCurricularService evaluacionFormativaCurricularService;

    @GetMapping("/evaluacionFormativaCurricular/list")
    public ResponseEntity<List<EvalucionFormativaCurricular>> listEvaluacionFormativaCurricular(){
        try {
            return new ResponseEntity<>(evaluacionFormativaCurricularService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/evaluacionFormativaCurricular/findbyId/{id}")
    public ResponseEntity<?> getEvalucionFormativaCurricularById(@PathVariable("id") Integer id){
        try {
            EvalucionFormativaCurricular dc = evaluacionFormativaCurricularService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("evaluacionFormativaCurricular NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/evaluacionFormativaCurricular/save")
    public ResponseEntity<EvalucionFormativaCurricular> saveEvaluacionFormativaCurricular(@RequestBody EvalucionFormativaCurricular efc){
        try {
            return new ResponseEntity<>(evaluacionFormativaCurricularService.save(efc), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/evaluacionFormativaCurricular/update/{id}")
    public ResponseEntity<EvalucionFormativaCurricular> actualizarEvalucionFormativaCurricular(@PathVariable Integer id, @RequestBody EvalucionFormativaCurricular evadiag) {
        try {
            if (evaluacionFormativaCurricularService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            evadiag.setTecnicaFormativa(evadiag.getTecnicaFormativa());
            evadiag.setInstrumnetoFormativa(evadiag.getInstrumnetoFormativa());
            evadiag.setDisenioCurricular(evadiag.getDisenioCurricular());
            EvalucionFormativaCurricular newObject = evaluacionFormativaCurricularService.save(evadiag);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //impl
    @GetMapping("/evaluacionFormativaporDisenioCurricular/findbyId/{idDisenioCurricular}")
    public ResponseEntity<?> getEvaluacionFormativaPorDisenioCurricular(@PathVariable("idDisenioCurricular") Integer idDisenioCurricular){
        try {
            List<EvalucionFormativaCurricular> nc = evaluacionFormativaCurricularService.findByDisenioCurricularIdDisenioCurricular(idDisenioCurricular);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
