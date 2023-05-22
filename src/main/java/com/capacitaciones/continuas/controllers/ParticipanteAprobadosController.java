package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.Modelos.Primary.ParticipantesAprobados;
import com.capacitaciones.continuas.Modelos.Primary.PartipantesMatriculados;
import com.capacitaciones.continuas.services.CursoService;
import com.capacitaciones.continuas.services.ParticipantesAprobadosService;
import com.capacitaciones.continuas.services.ParticipantesMatriculadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ParticipanteAprobadosController {

    @Autowired
    private ParticipantesAprobadosService participantesAprobadosService;

    @Autowired
    private ParticipantesMatriculadosService participantesMatriculadosService;

    @Autowired
    private CursoService cursoService;

    @GetMapping("/participantesAprobados/listar")
    public ResponseEntity<List<ParticipantesAprobados>> obtenerLista() {
        try {
            return new ResponseEntity<>(participantesAprobadosService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/participantesAprobados/crear")
    public ResponseEntity<ParticipantesAprobados> crear(@RequestBody ParticipantesAprobados c) {
        try {
            return new ResponseEntity<>(participantesAprobadosService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/participantesAprobados/findbyId/{id}")
    public ResponseEntity<?> getParticipantesAprobadosById(@PathVariable("id") Integer id){
        try {
            ParticipantesAprobados nc = participantesAprobadosService.findById(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>("PARTICIPANTE APROBADOS NO ENCONTRADA",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/participantesAprobados/actualizar/{id}")
    public ResponseEntity<ParticipantesAprobados> actualizarParticipantesAprobados(@PathVariable Integer id, @RequestBody ParticipantesAprobados participantesAprobados) {
        try {
            if (participantesAprobadosService.findById(id) == null) {
                return ResponseEntity.notFound().build();
            }
            participantesAprobados.setCodigoSenecyt(participantesAprobados.getCodigoSenecyt());
            return new ResponseEntity<>(participantesAprobadosService.save(participantesAprobados), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/participantesAprobados/findbyIdCurso/{id}")
    public ResponseEntity<List<ParticipantesAprobados>> getParticipantesAprobadosByIdCurso(@PathVariable("id") Integer id){
        try {
            List<ParticipantesAprobados> nc = participantesAprobadosService.findByPartipantesMatriculadosInscritoCursoIdCurso(id);
            if(nc != null){
                return new ResponseEntity<>(nc, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/existparticipantesAprobados/findbyIdCurso/{id}")
    public Boolean getParticipan(@PathVariable("id") Integer id){
       return participantesAprobadosService.existsByPartipantesMatriculadosInscritoCursoIdCurso(id);
    }

    //Metodo de guardadoFinal

    @GetMapping("/participantesAprobados/save/findbyIdCurso/{id}")
    public ResponseEntity<List<ParticipantesAprobados>> getParticipantesAprobadosByIdCursoSave(@PathVariable("id") Integer id){
        try {
           if(participantesAprobadosService.existsByPartipantesMatriculadosInscritoCursoIdCurso(id)){
               try {
                   List<ParticipantesAprobados> participantesAprobadosList = participantesAprobadosService.findByPartipantesMatriculadosInscritoCursoIdCurso(id);
                   return new ResponseEntity<>(participantesAprobadosList, HttpStatus.OK);
               }catch (Exception e){
                   return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
               }
           }else{
               List<ParticipantesAprobados> participantesActualizados = new ArrayList<>();

               List<PartipantesMatriculados> matriculadosList = participantesMatriculadosService.findByInscritoCursoIdCurso(id);
               matriculadosList.stream().forEach(pm ->{
                   if(pm.getEstadoParticipanteAprobacion().equals("A")){
                       ParticipantesAprobados participantesAprobados = new ParticipantesAprobados();
                       participantesAprobados.setPartipantesMatriculados(pm);
                       participantesAprobados.setCertificadoFirmado(false);
                       participantesAprobados.setCodigoSenecyt("");
                       participantesActualizados.add(participantesAprobadosService.save(participantesAprobados));
                   }
               });

               try {
                   Curso curso = cursoService.findById(id);
                   curso.setEstadoPublicasionCurso("F");
                   cursoService.save(curso);
               }catch (Exception ex){
                   System.out.println(ex.getMessage());
               }

               return new ResponseEntity<>(participantesActualizados, HttpStatus.OK);
           }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //UPDATE UNA CARAGA
    @PutMapping("/participantesAprobados/actualizar/lista")
    public ResponseEntity<List<ParticipantesAprobados>> actualizarParticipantesAprobadosLista(@RequestBody List<ParticipantesAprobados> participantesAprobados) {
        try {
            List<ParticipantesAprobados> participantesActualizados = new ArrayList<>();

            for (ParticipantesAprobados participante : participantesAprobados) {
                ParticipantesAprobados participanteExistente = participantesAprobadosService.findById(participante.getIdParticipantesAprobados());

                if (participanteExistente == null) {
                    return ResponseEntity.notFound().build();
                }
                try {
                    if(participante.getCertificadoParticipante() == null){
                        participante.setCertificadoFirmado(false);
                    }else{
                        participante.setCertificadoFirmado(true);
                    }
                }catch (Exception e){
                    System.out.println("Exeption status"+e.getMessage());
                }
                participanteExistente.setCodigoSenecyt(participante.getCodigoSenecyt());
                participanteExistente.setCertificadoParticipante(participante.getCertificadoParticipante());
                participanteExistente.setCertificadoFirmado(participante.getCertificadoFirmado());
                participantesActualizados.add(participantesAprobadosService.save(participanteExistente));
            }

            return ResponseEntity.ok(participantesActualizados);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
