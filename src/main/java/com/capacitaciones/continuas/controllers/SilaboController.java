package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Silabo;
import com.capacitaciones.continuas.services.SilaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class SilaboController {

    @Autowired
    SilaboService silaboService;

    @GetMapping("/silabo/listar")
    public ResponseEntity<List<Silabo>> obtenerLista() {
        return new ResponseEntity<>(silaboService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/silabo/crear")
    public ResponseEntity<Silabo> crear(@RequestBody Silabo c) {
        return new ResponseEntity<>(silaboService.save(c), HttpStatus.CREATED);
    }

    @GetMapping("/silabo/findbyId/{id}")
    public ResponseEntity<?> SilaboFindById(@PathVariable("id") Integer id){
        try {
            Silabo nc = silaboService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("SILABO NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/silabo/findbyIdCursoPorSilabo/{id}")
    public ResponseEntity<?> SilaboFindByIdPorCurso(@PathVariable("id") Integer id){
        try {
            Silabo nc = silaboService.SilabofindByCursoIdCurso(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("SILABO NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/silabo/findbyIdCurso/{idCurso}")
    public boolean SilabofindbyIdCurso(@PathVariable("idCurso") Integer idCurso){
        return silaboService.findByCursoIdCurso(idCurso);
    }

    @PutMapping("/silabo/actualizar/{id}")
    public ResponseEntity<Silabo> actualizarSilabo(@PathVariable Integer id, @RequestBody Silabo silabo) {
        try {
            if (silaboService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            silabo.setBibliografia(silabo.getBibliografia());
            silabo.setCampoRevisadoPor(silabo.getCampoRevisadoPor());
            silabo.setCampoAprovadoPor(silabo.getCampoAprovadoPor());

            return new ResponseEntity<>(silaboService.save(silabo), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
