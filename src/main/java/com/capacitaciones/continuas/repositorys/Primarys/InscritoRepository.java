package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Inscrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscritoRepository extends JpaRepository<Inscrito, Integer> {
    public List<Inscrito> findByCursoIdCurso(Integer idCurso);

    public Inscrito findByCursoIdCursoAndUsuarioIdUsuario(Integer idCurso, Integer idUsuario);


}
