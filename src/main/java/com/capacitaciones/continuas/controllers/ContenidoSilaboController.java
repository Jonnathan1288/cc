package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.ContenidoSilabo;
import com.capacitaciones.continuas.services.ContenidoSilaboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ContenidoSilaboController {
    @Autowired
    private ContenidoSilaboService contenidoSilaboService;

    @GetMapping("/contenidosilabo/list")
    public ResponseEntity<List<ContenidoSilabo>> listContenidoSilabo(){
        try {
            return new ResponseEntity<>(contenidoSilaboService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/contenidosilabo/save")
    public ResponseEntity<ContenidoSilabo> saveContenidoSilabo(@RequestBody ContenidoSilabo contenidoSilabo){
        try {
            return new ResponseEntity<>(contenidoSilaboService.save(contenidoSilabo), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contenidosilabo/findbyId/{id}")
    public ResponseEntity<?> getContenidosilaboById(@PathVariable("id") Integer id){
        try {
            ContenidoSilabo contenidoSilabo = contenidoSilaboService.findById(id);
            if(contenidoSilabo != null){
                return new ResponseEntity<>(contenidoSilabo, HttpStatus.OK);
            }
            return new ResponseEntity<>("CONTENIDO SILABO NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/contenidosilaboPorSilabo/findbyId/{IdSilabo}")
    public ResponseEntity<?> getResultadosPorSilabo(@PathVariable("IdSilabo") Integer IdSilabo){
        try {
            List<ContenidoSilabo> nc = contenidoSilaboService.findBySilaboIdSilabo(IdSilabo);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/contenidosilabo/actualizar/{id}")
    public ResponseEntity<ContenidoSilabo> actualizarCapacitador(@PathVariable Integer id, @RequestBody ContenidoSilabo contenidoSilabo) {

        try {
            if (contenidoSilaboService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            contenidoSilabo.setTemaContenido(contenidoSilabo.getTemaContenido());
            contenidoSilabo.setDiaContenido(contenidoSilabo.getDiaContenido());
            contenidoSilabo.setActividadesDocencia(contenidoSilabo.getActividadesDocencia());
            contenidoSilabo.setHorasClaseContenido(contenidoSilabo.getHorasClaseContenido());
            contenidoSilabo.setActividadesPracticas(contenidoSilabo.getActividadesPracticas());
            contenidoSilabo.setHorasPracticas(contenidoSilabo.getHorasPracticas());
            contenidoSilabo.setActividadesAutonomas(contenidoSilabo.getActividadesAutonomas());
            contenidoSilabo.setHorasAutonomas(contenidoSilabo.getHorasAutonomas());
            contenidoSilabo.setObservaciones(contenidoSilabo.getObservaciones());
            contenidoSilabo.setEstadoContenido(contenidoSilabo.getEstadoContenido());

            ContenidoSilabo newObject = contenidoSilaboService.save(contenidoSilabo);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
