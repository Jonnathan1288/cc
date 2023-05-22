package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "modalidades_cursos")
public class ModalidadCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modalidad_curso")
    private Integer idModalidadCurso;

    @Column(name = "estado_modalidad_curso", columnDefinition = "BOOLEAN")
    private Boolean estadoModalidadCurso;

    @Column(name = "nombre_modalidad_curso")
    private String nombreModalidadCurso;

}
