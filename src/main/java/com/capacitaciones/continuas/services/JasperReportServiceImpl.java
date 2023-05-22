package com.capacitaciones.continuas.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
@Service
public class JasperReportServiceImpl implements JasperReportService{
    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate jdbcTemplate;




@Override
    public void generateReportInformeNecesidadCurso(HttpServletResponse response, Integer idCursoNecesidadC) {
        try {

            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            //--------------------------------------------------------------------------------
            InputStream cene = getClass().getResourceAsStream("/images/cene.png");
            File tempFile1 = File.createTempFile("cene", ".png");
            tempFile1.deleteOnExit();
            Files.copy(cene, tempFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecene = tempFile1.getAbsolutePath();

            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/informeNecesidad.jasper");

            Map<String, Object> params = new HashMap<>();
            params.put("ista", imageista);
            params.put("cene", imagecene);
            params.put("idCurso", idCursoNecesidadC);


            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=report.pdf");
            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }
    
    @Override
    public void generateSilabo(HttpServletResponse response, Integer idSilabo) {
        try {
            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            //--------------------------------------------------------------------------------
            InputStream cene = getClass().getResourceAsStream("/images/cene.png");
            File tempFile1 = File.createTempFile("cene", ".png");
            tempFile1.deleteOnExit();
            Files.copy(cene, tempFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecene = tempFile1.getAbsolutePath();


            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/repsilabo.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", imagecene);
            params.put("ista", imageista);
            params.put("idSilaboPrimary", idSilabo);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=silaboReport.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

    @Override
    public void generateFichaInscripccion(HttpServletResponse response, Integer idCurso, Integer idUsuario) {
        try {

            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            InputStream cenep = getClass().getResourceAsStream("/images/cenep.png");
            File tempFile2 = File.createTempFile("cenep", ".png");
            tempFile2.deleteOnExit();
            Files.copy(cenep, tempFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecenep = tempFile2.getAbsolutePath();


            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/FormularioInscripción.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", imagecenep);
            params.put("ista", imageista);
            params.put("idCurso", idCurso);
            params.put("idUsuario", idUsuario);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=formularioIncripcion.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }


@Override
    public void generateRegisterFotografico(HttpServletResponse response, Integer idCurso) {
        try {

            InputStream cenep = getClass().getResourceAsStream("/images/cenep.png");
            File tempFile2 = File.createTempFile("cenep", ".png");
            tempFile2.deleteOnExit();
            Files.copy(cenep, tempFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecenep = tempFile2.getAbsolutePath();

            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/RegistroFotografico.jasper");
            Map<String, Object> params = new HashMap<>();

            params.put("cene", imagecenep);
            params.put("ista", imageista);

            //params.put("cene", "cenep.png");
            //params.put("ista", "ista.jpeg");
            params.put("idCurso", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=RegistroFotografico.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

@Override
    public void generateRegisterAsistenciaEvaluacion(HttpServletResponse response, Integer idCurso) {
        try {
            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            InputStream cenep = getClass().getResourceAsStream("/images/cenep.png");
            File tempFile2 = File.createTempFile("cenep", ".png");
            tempFile2.deleteOnExit();
            Files.copy(cenep, tempFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecenep = tempFile2.getAbsolutePath();


            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/RegistroAsistenciEvaluacion.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", imagecenep);
            params.put("ista", imageista);
            params.put("idCurso", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=RegistroAsistenciaEvaluacion.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

@Override
    public void generateInformeFinal(HttpServletResponse response, Integer idCurso) {
        try {
            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            InputStream cene = getClass().getResourceAsStream("/images/cene.png");
            File tempFile1 = File.createTempFile("cene", ".png");
            tempFile1.deleteOnExit();
            Files.copy(cene, tempFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecene = tempFile1.getAbsolutePath();

            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/ReporteFinalCurso.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", imagecene);
            params.put("ista", imageista);
            params.put("id_Curso", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=ReporteFinalCurso.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

    @Override
    public void generateRegistroParticipantes(HttpServletResponse response, Integer idCurso) {
        try {
            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            InputStream cene = getClass().getResourceAsStream("/images/cene.png");
            File tempFile1 = File.createTempFile("cene", ".png");
            tempFile1.deleteOnExit();
            Files.copy(cene, tempFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecene = tempFile1.getAbsolutePath();

            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/ReporteRegistroParticipantes.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", imagecene);
            params.put("ista", imageista);
            params.put("idCursoPrincipal", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=registroParticipantes.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

    @Override
    public void generateHojaVida(HttpServletResponse response, Integer idCapacitador) {
        try {
            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            InputStream cene = getClass().getResourceAsStream("/images/cene.png");
            File tempFile1 = File.createTempFile("cene", ".png");
            tempFile1.deleteOnExit();
            Files.copy(cene, tempFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecene = tempFile1.getAbsolutePath();


            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/reportHojadeVida.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", imagecene);
            params.put("ista", imageista);
            params.put("idCapacitador", idCapacitador);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=HojadeVida.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }
    
    @Override
    public void generateEntregaCertificadoCursoCapacitacion(HttpServletResponse response, Integer idcurso) {
        try {

            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            InputStream cene = getClass().getResourceAsStream("/images/cene.png");
            File tempFile1 = File.createTempFile("cene", ".png");
            tempFile1.deleteOnExit();
            Files.copy(cene, tempFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecene = tempFile1.getAbsolutePath();

            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/registroentregaCertificado.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", imagecene);
            params.put("istaf", imageista);
            params.put("idCurso", idcurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=EntregaCertificadoCurso.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

    @Override
    public void generatepRrogramacionMensual(HttpServletResponse response, Integer mes, Integer anio) {
        try {

            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            InputStream cenep = getClass().getResourceAsStream("/images/cenep.png");
            File tempFile2 = File.createTempFile("cenep", ".png");
            tempFile2.deleteOnExit();
            Files.copy(cenep, tempFile2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecenep = tempFile2.getAbsolutePath();


            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/ProgramacionMensual.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", imagecenep);
            params.put("ista", imageista);
            params.put("mes", mes);
            params.put("year", anio);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=ProgramacionMensual.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }
  
      @Override
    public void generateCodigoAsignarCenecyt(HttpServletResponse response, Integer idCurso) {
        try {

            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            InputStream cene = getClass().getResourceAsStream("/images/cene.png");
            File tempFile1 = File.createTempFile("cene", ".png");
            tempFile1.deleteOnExit();
            Files.copy(cene, tempFile1.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imagecene = tempFile1.getAbsolutePath();

            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/ListaCodigosAsiganar.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("cene", imagecene);
            params.put("ista", imageista);
            params.put("idCurso", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=codigoAsignarSnecyt.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

    @Override
    public void generateCertificadoEstudiante(HttpServletResponse response, Integer idCurso, String identificasion) {
        try {

            InputStream ga = getClass().getResourceAsStream("/images/gobi.png");
            File tempFile3 = File.createTempFile("gobi", ".png");
            tempFile3.deleteOnExit();
            Files.copy(ga, tempFile3.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String gobi = tempFile3.getAbsolutePath();

            InputStream ist = getClass().getResourceAsStream("/images/istatec.jpg");
            File tempFile4 = File.createTempFile("istatec", ".jpg");
            tempFile4.deleteOnExit();
            Files.copy(ist, tempFile4.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String istatec = tempFile4.getAbsolutePath();

            InputStream le = getClass().getResourceAsStream("/images/line.png");
            File tempFile5 = File.createTempFile("line", ".png");
            tempFile5.deleteOnExit();
            Files.copy(le, tempFile5.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String line = tempFile5.getAbsolutePath();

            InputStream re = getClass().getResourceAsStream("/images/republic.png");
            File tempFile6 = File.createTempFile("republic", ".png");
            tempFile6.deleteOnExit();
            Files.copy(re, tempFile6.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String republic = tempFile6.getAbsolutePath();

            InputStream se = getClass().getResourceAsStream("/images/secre.png");
            File tempFile7 = File.createTempFile("secre", ".png");
            tempFile7.deleteOnExit();
            Files.copy(se, tempFile7.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String secre = tempFile7.getAbsolutePath();

            InputStream tis = getClass().getResourceAsStream("/images/tian.png");
            File tempFile9 = File.createTempFile("tian", ".png");
            tempFile9.deleteOnExit();
            Files.copy(tis, tempFile9.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String tian = tempFile9.getAbsolutePath();

            InputStream tsp = getClass().getResourceAsStream("/images/tsin.png");
            File tempFile10 = File.createTempFile("tsin", ".png");
            tempFile10.deleteOnExit();
            Files.copy(tsp, tempFile10.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String tsin = tempFile10.getAbsolutePath();

            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/Certificado.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("g", gobi);
            params.put("is", istatec);
            params.put("l", line);
            params.put("r", republic);
            params.put("s", secre);
            params.put("ti", tian);
            params.put("ts", tsin);
            params.put("idCurso", idCurso);
            params.put("ci", identificasion);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=" + "Certificado"+identificasion + ".pdf");
            //response.setHeader("Content-Disposition", "attachment; filename=Certificado.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }


    @Override
    public void generateDisenioC(HttpServletResponse response, Integer idDisenioCurricular) {
        try {

            InputStream sececytp = getClass().getResourceAsStream("/images/senescyt.png");
            File tempFile8 = File.createTempFile("senescyt", ".png");
            tempFile8.deleteOnExit();
            Files.copy(sececytp, tempFile8.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String sececyt = tempFile8.getAbsolutePath();

            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/DiseñoC.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("senescyt", sececyt);
            params.put("idDisenioCPrimary", idDisenioCurricular);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=DiseñoCurricularReport.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

    @Override
    public void generateFichaEvaluacionFinal(HttpServletResponse response, Integer idCurso) {
        try {

            InputStream ista = getClass().getResourceAsStream("/images/ista.jpeg");
            File tempFile = File.createTempFile("ista", ".jpeg");
            tempFile.deleteOnExit();
            Files.copy(ista, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            String imageista = tempFile.getAbsolutePath();

            InputStream reportStream = this.getClass().getResourceAsStream("/Reports/fichaevaluacionCurso.jasper");
            Map<String, Object> params = new HashMap<>();
            params.put("ista", imageista);
            params.put("idCurso", idCurso);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, params, jdbcTemplate.getDataSource().getConnection());
            byte[] reportContent = JasperExportManager.exportReportToPdf(jasperPrint);

            response.setContentType("application/pdf");

            response.setHeader("Content-Disposition", "attachment; filename=FichaEvaluacionFinal.pdf");

            response.setContentLength(reportContent.length);

            OutputStream outStream = response.getOutputStream();
            outStream.write(reportContent);
            outStream.flush();
            outStream.close();
        }catch (Exception e){
            System.out.println( "eService " + e.getMessage());
        }
    }

}
