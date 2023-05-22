package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Inscrito;
import com.capacitaciones.continuas.services.InscritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class InscritoController {

    @Autowired
    private InscritoService inscritoService;

    @GetMapping("/inscritocurso/listar")
    public ResponseEntity<List<Inscrito>> obtenerLista() {
        try {
            return new ResponseEntity<>(inscritoService.findByAll(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/inscritocurso/findbyId/{id}")
    public ResponseEntity<?> getInformeFinalCursoById(@PathVariable("id") Integer id){
        try {
            Inscrito dc = inscritoService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("inscritocurso NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuarioInscrito/findbyIdUsuario/{idCurso}/{idUsuario}")
    public ResponseEntity<?> usuarioInscritoByIdUsuario(@PathVariable Integer idCurso,@PathVariable Integer idUsuario){
        try {
            Inscrito dc = inscritoService.findByUsuarioIdUsuario(idCurso,idUsuario);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("inscritocurso NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/inscritocursoPorCurso/findbyIdCurso/{id}")
    public ResponseEntity<?> getInformeFinalCursoByIdCurso(@PathVariable("id") Integer id){
        try {
            List<Inscrito> dc = inscritoService.findByCursoIdCurso(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("inscritocurso NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping("/validarCursoAplicadoUsuario/findbyIdCursoAndIdUsuario/{idCurso}/{idUsuario}")
    public boolean validarCursoAplicadoUsuario(@PathVariable Integer idCurso,@PathVariable Integer idUsuario){
        return inscritoService.findByCursoIdCursoAndUsuarioIdUsuario(idCurso,idUsuario);
    }

    @PostMapping("/inscritocurso/crear")
    public ResponseEntity<Inscrito> crear(@RequestBody Inscrito c) {
        try {
            c.setFechaInscrito(LocalDate.now());
            return new ResponseEntity<>(inscritoService.save(c), HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/inscritocurso/update/{id}")
    public ResponseEntity<Inscrito> actualizarInscrito(@PathVariable Integer id, @RequestBody Inscrito inscrito) {
        try {
            if (inscritoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            inscrito.setFechaInscrito(inscrito.getFechaInscrito());
            inscrito.setEstadoInscrito(inscrito.getEstadoInscrito());
            inscrito.setEstadoInscritoActivo(inscrito.getEstadoInscritoActivo());
            inscrito.setUsuario(inscrito.getUsuario());
            inscrito.setCurso(inscrito.getCurso());
            Inscrito newObject = inscritoService.save(inscrito);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
