package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.ResultadoAprendizajeSilabo;
import com.capacitaciones.continuas.services.ResultadoAprendizajeSilaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ResultadoAprendizajeSilaboController {

    @Autowired
    ResultadoAprendizajeSilaboService resultadoAprendizajeSilaboService;

    @GetMapping("/resultadoAprendizajeSilabo/listar")
    public ResponseEntity<List<ResultadoAprendizajeSilabo>> obtenerLista() {
        try {
        return new ResponseEntity<>(resultadoAprendizajeSilaboService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/resultadoAprendizajeSilabo/crear")
    public ResponseEntity<ResultadoAprendizajeSilabo> crear(@RequestBody ResultadoAprendizajeSilabo c) {
        try {
        return new ResponseEntity<>(resultadoAprendizajeSilaboService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/resultadoAprendizajeSilabo/findbyId/{id}")
    public ResponseEntity<?> getResultadoAprendizajeSilabo(@PathVariable("id") Integer id){
        try {
            ResultadoAprendizajeSilabo nc = resultadoAprendizajeSilaboService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("RESULTADO APRENDIZAJE APROBADOS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/resultadoAprendizajeSilaboIdSilabo/findbyId/{IdSilabo}")
    public ResponseEntity<?> getResultadosPorSilabo(@PathVariable("IdSilabo") Integer IdSilabo){
        try {
            List<ResultadoAprendizajeSilabo> nc = resultadoAprendizajeSilaboService.findBySilaboIdSilabo(IdSilabo);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("RESULTADO APRENDIZAJE APROBADOS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/resultadoAprendizajeSilabo/actualizar/{id}")
    public ResponseEntity<ResultadoAprendizajeSilabo> actualizarResultadoAprendizajeSilabo(@PathVariable Integer id, @RequestBody ResultadoAprendizajeSilabo resultadoAprendizajeSilabo) {
        try {
            if (resultadoAprendizajeSilaboService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            resultadoAprendizajeSilabo.setTemaUnidadSilabo(resultadoAprendizajeSilabo.getTemaUnidadSilabo());
            resultadoAprendizajeSilabo.setElementosCompetenciaSilabo(resultadoAprendizajeSilabo.getElementosCompetenciaSilabo());
            resultadoAprendizajeSilabo.setActivadesResultadoAprendizaje(resultadoAprendizajeSilabo.getActivadesResultadoAprendizaje());
            resultadoAprendizajeSilabo.setFormaEvidenciar(resultadoAprendizajeSilabo.getFormaEvidenciar());
            resultadoAprendizajeSilabo.setEstadoUnidadActivo(resultadoAprendizajeSilabo.getEstadoUnidadActivo());

            return new ResponseEntity<>(resultadoAprendizajeSilaboService.save(resultadoAprendizajeSilabo), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
