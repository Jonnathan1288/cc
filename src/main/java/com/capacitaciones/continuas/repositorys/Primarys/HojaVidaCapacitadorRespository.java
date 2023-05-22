package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.HojaVidaCapacitador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HojaVidaCapacitadorRespository extends JpaRepository<HojaVidaCapacitador, Integer> {

    public HojaVidaCapacitador findHojaVidaCapacitadorByCapacitador_IdCapacitador(Integer idCapacitador);

    public HojaVidaCapacitador findHojaVidaCapacitadorByCapacitadorUsuarioIdUsuario(Integer iDUsuario);

    HojaVidaCapacitador findByCapacitadorUsuarioIdUsuario(Integer idUsuario);

}

