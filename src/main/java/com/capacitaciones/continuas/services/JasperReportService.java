package com.capacitaciones.continuas.services;

import javax.servlet.http.HttpServletResponse;

public interface JasperReportService {

    public void generateReportInformeNecesidadCurso(HttpServletResponse response, Integer idCursoNecesidadC);

    public void generateSilabo(HttpServletResponse response, Integer ids);

    public void generateFichaInscripccion(HttpServletResponse response, Integer idCurso, Integer idUsuario);

    public void generateRegisterFotografico(HttpServletResponse response, Integer idCurso);

    public void generateRegisterAsistenciaEvaluacion(HttpServletResponse response, Integer idCurso);

    public void generateInformeFinal(HttpServletResponse response, Integer idCurso);

    public void generateRegistroParticipantes(HttpServletResponse response, Integer idCurso);

    public void generateHojaVida(HttpServletResponse response, Integer idCapacitador);
    public void generateEntregaCertificadoCursoCapacitacion(HttpServletResponse response, Integer idcurso);

    public void generatepRrogramacionMensual(HttpServletResponse response, Integer mes, Integer anio);


    public void generateCodigoAsignarCenecyt(HttpServletResponse response, Integer idCurso);

    public void generateCertificadoEstudiante(HttpServletResponse response, Integer idCurso, String identificasion);

    public void generateDisenioC(HttpServletResponse response, Integer ids);

    public void generateFichaEvaluacionFinal(HttpServletResponse response, Integer idCurso);

}
