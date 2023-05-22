package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.MaterialAudiovisual;
import com.capacitaciones.continuas.repositorys.Primarys.MaterialAudiovisualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialAudiovisualServiceImpl extends GenericServiceImpl<MaterialAudiovisual, Integer> implements MaterialAudiovisualService {

    @Autowired
    private MaterialAudiovisualRepository materialAudiovisualRepository;

    @Override
    public CrudRepository<MaterialAudiovisual, Integer> getDao() {
        return materialAudiovisualRepository;
    }

    public List<MaterialAudiovisual> findBySilaboIdSilabo(Integer idSilabo) {
        return materialAudiovisualRepository.findBySilaboIdSilabo(idSilabo);
    }
}
