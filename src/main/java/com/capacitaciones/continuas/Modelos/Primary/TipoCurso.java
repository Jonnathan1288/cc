package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tipos_cursos")
public class TipoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_curso")
    private Integer idTipoCurso;

    @Column(name = "estado_tipo_curso", columnDefinition = "BOOLEAN")
    private Boolean estadoTipoCurso;

    @Column(name = "nombre_tipo_curso", length = 500)
    private String nombreTipoCurso;

}
