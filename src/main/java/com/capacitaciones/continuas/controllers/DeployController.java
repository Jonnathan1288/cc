package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class DeployController {
    @GetMapping("/")
    public String deployMethod(){
        try {
            return "Successful deploy proyect in AWS..";
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
            return "Error deploy in AWS..";
        }
    }

}
