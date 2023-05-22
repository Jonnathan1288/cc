package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.MaterialAudiovisual;

import java.util.List;

public interface MaterialAudiovisualService extends  GenericService<MaterialAudiovisual, Integer>{

    List<MaterialAudiovisual> findBySilaboIdSilabo(Integer idSilabo);
}
