package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import com.capacitaciones.continuas.services.CapacitadorService;
import com.capacitaciones.continuas.services.HojaVidaCapacitadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class HojaVidaCapacitadorController {

    @Autowired
    HojaVidaCapacitadorService hojaVidaCapacitadorService;

    @Autowired
    CapacitadorService capacitadorService;

    @GetMapping("/hojaVidaCapcitador/listar")
    public ResponseEntity<List<HojaVidaCapacitador>> obtenerLista() {
        try {
            return new ResponseEntity<>(hojaVidaCapacitadorService.findByAll(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hojaVidaCapcitador/findbyId/{id}")
    public ResponseEntity<?> getHojaVidaCapacitadorById(@PathVariable("id") Integer id){
        try {
            HojaVidaCapacitador dc = hojaVidaCapacitadorService.findById(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("hojaVidaCapcitador NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hojaVidaCapcitadorValidar/findbyIdUsuario/{id}")
    public boolean hojaVidaCapcitadorValidar(@PathVariable("id") Integer id){
        return hojaVidaCapacitadorService.findByCapacitadorUsuarioIdUsuario(id);
    }

    @PostMapping("/hojaVida/saveDocumento/{idUsuario}")
    public ResponseEntity<?> guardarCV(@RequestParam("file") MultipartFile file,@PathVariable("idUsuario") Integer idUsuario) throws IOException {
        Capacitador capacitador = capacitadorService.findByUsuarioIdUsuario(idUsuario);
        if(capacitador == null){
            return ResponseEntity.badRequest().body("No se encontro CAPACITADOR.");
        }
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha proporcionado ningún archivo.");
        }
        byte[] bytesDocumento = file.getBytes();
        return new ResponseEntity<>(hojaVidaCapacitadorService.guardarCV(bytesDocumento,capacitador), HttpStatus.CREATED);
    }

    @PostMapping("/hojaVida/updateDocumento/{idUsuario}")
    public ResponseEntity<?> updateCVDocumento(@RequestParam("file") MultipartFile file,@PathVariable("idUsuario") Integer idUsuario) throws IOException {
        HojaVidaCapacitador hojaVidaCapacitador = hojaVidaCapacitadorService.findHojaVidaCapacitadorByCapacitadorUsuarioIdUsuario(idUsuario);
        if(hojaVidaCapacitador == null){
            return ResponseEntity.badRequest().body("No se encontro CAPACITADOR.");
        }
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().body("No se ha proporcionado ningún archivo.");
        }
        byte[] bytesDocumento = file.getBytes();
        return new ResponseEntity<>(hojaVidaCapacitadorService.updateCVCapacitador(bytesDocumento,hojaVidaCapacitador), HttpStatus.CREATED);
    }

    @PostMapping("/hojaVidaCapcitador/crear")
    public ResponseEntity<HojaVidaCapacitador> crear(@RequestBody HojaVidaCapacitador c) {
        try {
            return new ResponseEntity<>(hojaVidaCapacitadorService.save(c), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/hojaVidaCapcitador/update/{id}")
    public ResponseEntity<HojaVidaCapacitador> actualizarHojaVidaCapacitador(@PathVariable Integer id, @RequestBody HojaVidaCapacitador hv) {
        try {
            HojaVidaCapacitador hojavida = hojaVidaCapacitadorService.findById(id);
            if(hojavida != null){
                hojavida.setExperiencialLaboral(hv.getExperiencialLaboral());
                hojavida.setSobreMi(hv.getSobreMi());
                hojavida.setExperienciaEscolar(hv.getExperienciaEscolar());
                hojavida.setDestrezas(hv.getDestrezas());
                hojavida.setIdiomas(hv.getIdiomas());
                hojavida.setCapacitador(hv.getCapacitador());
                hojavida.setEstadoAprobacion(hv.getEstadoAprobacion());
                return new ResponseEntity<>(hojaVidaCapacitadorService.save(hojavida), HttpStatus.CREATED);
            }
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hojaVidaCapcitador/findbyIdCapacitador/{id}")
    public ResponseEntity<?> getHojaVidaCapacitadorByIdCapacitador(@PathVariable("id") Integer id){
        try {
            HojaVidaCapacitador dc = hojaVidaCapacitadorService.findHojaVidaCapacitadorByCapacitador_IdCapacitador(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("hojaVidaCapcitador NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/hojaVidaCapcitador/findbyCapacitdorUsuarioId/{id}")
    public ResponseEntity<?> getHojaVidaCapacitadorUsuarioById(@PathVariable("id") Integer id){
        try {
            HojaVidaCapacitador dc = hojaVidaCapacitadorService.findHojaVidaCapacitadorByCapacitadorUsuarioIdUsuario(id);
            if(dc != null){
                return new ResponseEntity<>(dc, HttpStatus.OK);
            }
            return new ResponseEntity<>("hojaVidaCapcitador NO ENCONTRADA",HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
