package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.Modelos.Primary.PruebaPdf;
import com.capacitaciones.continuas.services.pdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class pdfController {
    @Autowired
    private pdfService pdf;

    @GetMapping("/pdf/list")
    public ResponseEntity<List<PruebaPdf>> listPdf(){
        try {
            return new ResponseEntity<>(pdf.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pdf/findbyId/{id}")
    public ResponseEntity<?> getAreaById(@PathVariable("id") Integer id){
        try {
            PruebaPdf area = pdf.findById(id);
            if(area != null){
                return new ResponseEntity<>(area, HttpStatus.OK);
            }
            return new ResponseEntity<>("AREA NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pdf/save")
    public ResponseEntity<PruebaPdf> saveArea(@RequestBody PruebaPdf area){
        try {
            return new ResponseEntity<>(pdf.save(area), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
