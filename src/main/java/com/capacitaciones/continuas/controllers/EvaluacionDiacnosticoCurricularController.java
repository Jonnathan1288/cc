package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.EvaluacionDiagnosticaCurricular;
import com.capacitaciones.continuas.services.EvaluacionDiacnosticaCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EvaluacionDiacnosticoCurricularController {
    @Autowired
    private EvaluacionDiacnosticaCurricularService evaluacionDiacnosticaCurricularService;

    @GetMapping("/evaluacionDiacnosticaCurricular/list")
    public ResponseEntity<List<EvaluacionDiagnosticaCurricular>> listEvaluacionDiacnosticoCurricular(){
        try {
            return new ResponseEntity<>(evaluacionDiacnosticaCurricularService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/evaluacionDiacnosticaCurricular/findbyId/{id}")
    public ResponseEntity<?> getEvaluacionDiacnosticaCurricularById(@PathVariable("id") Integer id){
        try {
            EvaluacionDiagnosticaCurricular dc = evaluacionDiacnosticaCurricularService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("evaluacionDiacnosticaCurricular NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/evaluacionDiacnosticaCurricular/save")
    public ResponseEntity<?> saveEvaluacionDiacnosticoCurricular(@RequestBody EvaluacionDiagnosticaCurricular ev){
        try {
            return new ResponseEntity<>(evaluacionDiacnosticaCurricularService.save(ev), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("-> "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/evaluacionDiacnosticaCurricular/update/{id}")
    public ResponseEntity<EvaluacionDiagnosticaCurricular> actualizarEvaluacionDiagnosticaCurricular(@PathVariable Integer id, @RequestBody EvaluacionDiagnosticaCurricular evadiag) {
        try {
            if (evaluacionDiacnosticaCurricularService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            evadiag.setTecnicaEvaluar(evadiag.getTecnicaEvaluar());
            evadiag.setInstrumnetoEvaluar(evadiag.getInstrumnetoEvaluar());
            evadiag.setDisenioCurricular(evadiag.getDisenioCurricular());
            EvaluacionDiagnosticaCurricular newObject = evaluacionDiacnosticaCurricularService.save(evadiag);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Impl
    @GetMapping("/evaluacionDiagnosticaporDisenioCurricular/findbyId/{idDisenioCurricular}")
    public ResponseEntity<?> getEvaluacionDiagnosticaPorDisenioCurricular(@PathVariable("idDisenioCurricular") Integer idDisenioCurricular){
        try {
            List<EvaluacionDiagnosticaCurricular> nc = evaluacionDiacnosticaCurricularService.findByDisenioCurricularIdDisenioCurricular(idDisenioCurricular);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
