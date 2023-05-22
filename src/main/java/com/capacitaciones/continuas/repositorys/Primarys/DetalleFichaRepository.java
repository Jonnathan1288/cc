package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.DetalleFichaMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFichaRepository extends JpaRepository<DetalleFichaMatricula, Integer> {

    public DetalleFichaMatricula findByUsuarioIdUsuario(Integer idUsuario);
}
