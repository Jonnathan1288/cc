package com.capacitaciones.continuas.emailPassword.Services;

import com.capacitaciones.continuas.Modelos.Primary.Inscrito;
import com.capacitaciones.continuas.emailPassword.Dtos.EmailValuesDTO;

public interface EmailService {

    boolean sendEmail(EmailValuesDTO values);

    public boolean sendEmailEstudiantesMatriculadosNoMatriculados(Integer idCurso, String sendFrom);

}
