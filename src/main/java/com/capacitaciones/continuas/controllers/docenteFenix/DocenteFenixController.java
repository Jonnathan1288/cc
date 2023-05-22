package com.capacitaciones.continuas.controllers.docenteFenix;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.Modelos.Secondary.DocenteFenix;
import com.capacitaciones.continuas.services.DocenteFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/fenix")
public class DocenteFenixController {

    @Autowired
    private DocenteFenixService docenteFenixService;

    @GetMapping("/docente/ista/list")
    public ResponseEntity<List<DocenteFenix>> listarDocenteFenix(){
        try {
            return new ResponseEntity<>(docenteFenixService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/docente/ista/findbyIdentificasion/{identificasion}")
    public ResponseEntity<DocenteFenix> findByIdentificasionDocenteFenix(@PathVariable("identificasion") String identificasion){
        try {
            DocenteFenix docenteFenix = docenteFenixService.findByAndIdentificacion(identificasion);
            if(docenteFenix != null){
                return new ResponseEntity<>(docenteFenix, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
