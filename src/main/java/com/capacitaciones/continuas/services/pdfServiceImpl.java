package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.PartipantesMatriculados;
import com.capacitaciones.continuas.Modelos.Primary.PruebaPdf;
import com.capacitaciones.continuas.repositorys.Primarys.ParticipantesMatriculadosRepository;
import com.capacitaciones.continuas.repositorys.Primarys.Pruebarepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pdfServiceImpl extends GenericServiceImpl<PruebaPdf, Integer> implements pdfService {

    @Autowired
    private Pruebarepo pruebarepo;

    @Override
    public CrudRepository<PruebaPdf, Integer> getDao() {
        return pruebarepo;
    }

}
