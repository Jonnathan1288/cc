package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.DocumentoSenecyt;
import com.capacitaciones.continuas.Modelos.Primary.PruebaPdf;
import com.capacitaciones.continuas.services.DocumentoSenecytService;
import com.capacitaciones.continuas.services.pdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class DocumentoSenecytController {
    @Autowired
    private DocumentoSenecytService documentoSenecytService;

    @GetMapping("/documentosenecyt/list")
    public ResponseEntity<List<DocumentoSenecyt>> listDocumentoSenecyt(){
        try {
            return new ResponseEntity<>(documentoSenecytService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/documentosenecyt/findbyId/{id}")
    public ResponseEntity<?> getDocumentoSenecytById(@PathVariable("id") Integer id){
        try {
            DocumentoSenecyt area = documentoSenecytService.findById(id);
            if(area != null){
                return new ResponseEntity<>(area, HttpStatus.OK);
            }
            return new ResponseEntity<>("DOCUMENT NOT FOUND",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/documentosenecyt/save")
    public ResponseEntity<DocumentoSenecyt> saveDocumentoSenecyt(@RequestBody DocumentoSenecyt documentoSenecyt){
        try {
            documentoSenecyt.setFechaCreacion(LocalDate.now());
            return new ResponseEntity<>(documentoSenecytService.save(documentoSenecyt), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/documentosenecyt/update/{id}")
    public ResponseEntity<DocumentoSenecyt> updateDocumentoSenecyt(@RequestBody DocumentoSenecyt documentoSenecyt, @PathVariable("id") Integer id ){
        try {
            DocumentoSenecyt area = documentoSenecytService.findById(id);
            if(area != null){
                area.setDocumentoExel(documentoSenecyt.getDocumentoExel());
                area.setDescripcion(documentoSenecyt.getDescripcion());
                area.setEstadoDocumento(documentoSenecyt.getEstadoDocumento());
                area.setFechaCreacion(documentoSenecyt.getFechaCreacion());
                area.setUsuario(documentoSenecyt.getUsuario());
                return new ResponseEntity<>(documentoSenecytService.save(area), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
