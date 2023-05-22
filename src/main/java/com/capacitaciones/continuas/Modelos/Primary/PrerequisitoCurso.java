package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "prerequisitos_cursos")
public class PrerequisitoCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prerequisito_curso")
    private Integer idPrerequisitoCurso;

    @Column(name = "estado_prerequisito_curso", columnDefinition = "BOOLEAN")
    private Boolean estadoPrerequisitoCurso;

    @Column(name = "nombre_prerequisito_curso", length = 1300)
    private String nombrePrerequisitoCurso;

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    private Curso curso;

}

