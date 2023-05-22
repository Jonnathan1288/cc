package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.HorarioCurso;
import com.capacitaciones.continuas.services.HorarioCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class HorarioCursoController {

    @Autowired
    private HorarioCursoService horarioCursoService;

    @GetMapping("/horarioCurso/listar")
    public ResponseEntity<List<HorarioCurso>> obtenerHorarioCurso() {
        try {
            return new ResponseEntity<>(horarioCursoService.findByAll(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/horarioCurso/findbyId/{id}")
    public ResponseEntity<?> getHorarioCursoById(@PathVariable("id") Integer id){
        try {
            HorarioCurso dc = horarioCursoService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("horarioCurso NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/horarioCurso/crear")
    public ResponseEntity<HorarioCurso> crearHorarioCurso(@RequestBody HorarioCurso c) {
        try {
            return new ResponseEntity<>(horarioCursoService.save(c), HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/horarioCurso/update/{id}")
    public ResponseEntity<HorarioCurso> actualizarHorarioCurso(@PathVariable Integer id, @RequestBody HorarioCurso horario) {
        try {
            if (horarioCursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            horario.setEstadoHorarioCurso(horario.getEstadoHorarioCurso());
            horario.setDias(horario.getDias());
            horario.setHoraInicio(horario.getHoraInicio());
            horario.setHoraFin(horario.getHoraFin());
            HorarioCurso newObject = horarioCursoService.save(horario);
            return new ResponseEntity<>(newObject, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
