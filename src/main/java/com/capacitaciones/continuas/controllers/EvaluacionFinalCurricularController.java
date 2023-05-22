package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.EvaluacionFinalCurricular;
import com.capacitaciones.continuas.services.EvaluacionFinalCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EvaluacionFinalCurricularController {
    @Autowired
    private EvaluacionFinalCurricularService evaluacionFinalCurricularService;

    @GetMapping("/evaluacionFinalCurricular/list")
    public ResponseEntity<List<EvaluacionFinalCurricular>> listEvaluacionFinalCurricular(){
        try {
            return new ResponseEntity<>(evaluacionFinalCurricularService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/evaluacionFinalCurricular/findbyId/{id}")
    public ResponseEntity<?> getEvaluacionFinalCurricularById(@PathVariable("id") Integer id){
        try {
            EvaluacionFinalCurricular dc = evaluacionFinalCurricularService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("evaluacionFinalCurricular NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/evaluacionFinalCurricular/save")
    public ResponseEntity<EvaluacionFinalCurricular> saveEvaluacionFinalCurricular(@RequestBody EvaluacionFinalCurricular ef){
        try {
            return new ResponseEntity<>(evaluacionFinalCurricularService.save(ef), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/evaluacionFinalCurricular/update/{id}")
    public ResponseEntity<EvaluacionFinalCurricular> actualizarEvaluacionDiagnosticaCurricular(@PathVariable Integer id, @RequestBody EvaluacionFinalCurricular evadiag) {
        try {
            if (evaluacionFinalCurricularService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            evadiag.setTecnicaFormativaFinal(evadiag.getTecnicaFormativaFinal());
            evadiag.setInstrumnetoFormativaFinal(evadiag.getInstrumnetoFormativaFinal());
            evadiag.setDisenioCurricular(evadiag.getDisenioCurricular());
            EvaluacionFinalCurricular newObject = evaluacionFinalCurricularService.save(evadiag);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Impl
    @GetMapping("/evaluacionFinalporDisenioCurricular/findbyId/{idDisenioCurricular}")
    public ResponseEntity<?> getEvaluacionFinalPorDisenioCurricular(@PathVariable("idDisenioCurricular") Integer idDisenioCurricular){
        try {
            List<EvaluacionFinalCurricular> nc = evaluacionFinalCurricularService.findByDisenioCurricularIdDisenioCurricular(idDisenioCurricular);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
