package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/curso/list")
    public ResponseEntity<List<Curso>> listCurso(){
        try {
            return new ResponseEntity<>(cursoService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/cursoDisponibles/list")
    public ResponseEntity<List<Curso>> listCursoDisponibles(){
        try {
            return new ResponseEntity<>(cursoService.findByEstadoCursoAndEstadoPublicasionCurso(true), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cursosDelParticipante/list/{idParticipante}")
    public ResponseEntity<List<Curso>> listCursoDelParticipante(@PathVariable("idParticipante") Integer idParticipante){
        try {
            return new ResponseEntity<>(cursoService.findCursosDelParticipante(idParticipante), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/curso/findbyId/{id}")
    public ResponseEntity<?> getCursoById(@PathVariable("id") Integer id){
        try {
            Curso curso = cursoService.findById(id);
            if(curso != null){
                return new ResponseEntity<>(curso, HttpStatus.OK);
            }
            return new ResponseEntity<>("CURSO NO ENCONTRADO", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/curso/findAllIdUsuario/{id}")
    public ResponseEntity<?> obtenerTodoslosCursosPorIdCapacitador(@PathVariable("id") Integer id){
        try {
            List<Curso> cursoList= cursoService.findByCapacitadorIdCapacitador(id);
            if(cursoList != null){
                return new ResponseEntity<>(cursoList, HttpStatus.OK);
            }
            return new ResponseEntity<>("MIS CURSOS NO ENCONTRADOS", HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/curso/save")
    public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso){
        try {
            //Aprovacion del curso // N = NO NO APROVADO, A = APROVADO, P = PENDIENTE
            curso.setEstadoAprovacionCurso("P");
            curso.setEstadoPublicasionCurso("O");
            curso.setEstadoCurso(true);
            //curso.setIniciocurso(false);
            return new ResponseEntity<>(cursoService.save(curso), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/curso/update/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Integer id, @RequestBody Curso curso) {
        try {
            if (cursoService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            curso.setNombreCurso(curso.getNombreCurso());
            curso.setFotoCurso(curso.getFotoCurso());
            curso.setDuracionCurso(curso.getDuracionCurso());
            curso.setObservacionCurso(curso.getObservacionCurso());
            curso.setEstadoCurso(curso.getEstadoCurso());
            curso.setEstadoAprovacionCurso(curso.getEstadoAprovacionCurso());
            curso.setEstadoPublicasionCurso(curso.getEstadoPublicasionCurso());
            curso.setDescripcionCurso(curso.getDescripcionCurso());
            curso.setObjetivoGeneralesCurso(curso.getObjetivoGeneralesCurso());
            curso.setNumeroCuposCurso(curso.getNumeroCuposCurso());
            curso.setProgramas(curso.getProgramas());
            curso.setEspecialidad(curso.getEspecialidad());
            curso.setCapacitador(curso.getCapacitador());
            curso.setModalidadCurso(curso.getModalidadCurso());
            curso.setTipoCurso(curso.getTipoCurso());
            curso.setNivelCurso(curso.getNivelCurso());
            curso.setHorarioCurso(curso.getHorarioCurso());
            curso.setCursoocc(curso.getCursoocc());
            //curso.setIniciocurso(curso.getIniciocurso());

            Curso c = cursoService.save(curso);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
