package com.capacitaciones.continuas.controllers.docenteFenix;

import com.capacitaciones.continuas.Modelos.Secondary.DocenteFenix;
import com.capacitaciones.continuas.Modelos.Secondary.EstudianteFenix;
import com.capacitaciones.continuas.services.DocenteFenixService;
import com.capacitaciones.continuas.services.EstudianteFenixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class EstudianteFenixController {

    @Autowired
    private EstudianteFenixService estudianteFenixService;

    @GetMapping("/fenix/estudiante/ista/list")
    public ResponseEntity<List<EstudianteFenix>> listarEstudianteFenix(){
        try {
            return new ResponseEntity<>(estudianteFenixService.findByAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fenix/estudiante/ista/findbyIdentificasion/{identificasion}")
    public ResponseEntity<EstudianteFenix> findByIdentificasionEstudianteFenix(@PathVariable("identificasion") String identificasion){
        try {
            EstudianteFenix estudianteFenix = estudianteFenixService.findByAndIdentificacion(identificasion);
            if(estudianteFenix != null){
                return new ResponseEntity<>(estudianteFenix, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
