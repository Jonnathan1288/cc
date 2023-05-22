package com.capacitaciones.continuas.controllers;

import com.capacitaciones.continuas.services.JasperReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ReportsController {
    @Autowired
    private JasperReportService jasperReportService;

    @GetMapping("/reports/download-report/necesidad-curso/{id}")
    public void downloadReportNecesidadCurso(HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        try {
            jasperReportService.generateReportInformeNecesidadCurso(response, id);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }


    @GetMapping("/generarSilabo/downloadSilabo/{id}")
    public void downloadSilabo(HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        try {
            jasperReportService.generateSilabo(response, id);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarFichaInscripcion/downloadFicha/{idCurso}/{idUsusario}")
    public void downloadFichaInscripcion(HttpServletResponse response, @PathVariable("idCurso") Integer idCurso, @PathVariable("idUsusario") Integer idUsusario) throws Exception {
        try {
            jasperReportService.generateFichaInscripccion(response, idCurso, idUsusario);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }


    @GetMapping("/generarRegisroFotografico/downloadRegistroFotografico/{idCurso}")
    public void downloadRegistroFotografico(HttpServletResponse response, @PathVariable("idCurso") Integer idCurso) throws Exception {
        try {
            jasperReportService.generateRegisterFotografico(response, idCurso);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarInformeFinal/downloadInforme/{id_curso}")
    public void downloadInformeFinal(HttpServletResponse response, @PathVariable("id_curso") Integer id_curso) throws Exception {
        try {
            jasperReportService.generateInformeFinal(response, id_curso);

        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarRegistroAsistenciaEvaluacion/download/{idCurso}")
    public void downloadRegistroAsistenciaEvaluacion(HttpServletResponse response, @PathVariable("idCurso") Integer idCurso) throws Exception {
        try {
            jasperReportService.generateRegisterAsistenciaEvaluacion(response, idCurso);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarRegistroParticipantes/downloadRegistro/{id_curso}")
    public void downloadRegistroParticipantes(HttpServletResponse response, @PathVariable("id_curso") Integer id_curso) throws Exception {
        try {
            jasperReportService.generateRegistroParticipantes(response, id_curso);

        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarHojaVida/Docente/download/{idCapacitador}")
    public void downloadHojaVida(HttpServletResponse response, @PathVariable("idCapacitador") Integer idCapacitador) throws Exception {
        try {
            jasperReportService.generateHojaVida(response, idCapacitador);

        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

@GetMapping("/entregaCertificadosCursoCapacitacion/download/{idCurso}")
    public void downloadEntregaCertificadosCursoCpacitacion(HttpServletResponse response, @PathVariable("idCurso") Integer idCurso) throws Exception {
        try {
            jasperReportService.generateEntregaCertificadoCursoCapacitacion(response, idCurso);

        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/programacionMensual/download/{mes}/{anio}")
    public void downloadProgramacionMensul(HttpServletResponse response, @PathVariable("mes") Integer mes, @PathVariable("anio") Integer anio) throws Exception {
        try {
            jasperReportService.generatepRrogramacionMensual(response, mes, anio);

        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarCodigosAsignarSenecyt/Docente/download/{idCurso}")
    public void generarCodigosAsignarSenecyt(HttpServletResponse response, @PathVariable("idCurso") Integer idCurso) throws Exception {
        try {
            jasperReportService.generateCodigoAsignarCenecyt(response, idCurso);

        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }




    @GetMapping("/generarDisenioCurricular/downloadDisenioC/{id}")
    public void downloadDisenioC(HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        try {
            jasperReportService.generateDisenioC(response, id);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

    @GetMapping("/generarFichaEvaluacionFinalCurso/downloadDisenioC/{idCurso}")
    public void downloadFichaEvaluacionFinalCurso(HttpServletResponse response, @PathVariable("idCurso") Integer idCurso) throws Exception {
        try {
            jasperReportService.generateFichaEvaluacionFinal(response, idCurso);
        }catch (Exception e){
            System.out.println("Err-> "+e.getMessage());
        }
    }

}
