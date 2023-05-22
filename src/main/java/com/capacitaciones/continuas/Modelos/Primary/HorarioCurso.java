package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "horarioscursos")
public class HorarioCurso { //entidad en vigencia.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario_curso")
    private Integer idHorarioCurso;

    @Column(name = "estado_horario_curso", columnDefinition = "BOOLEAN")
    private Boolean estadoHorarioCurso;

    @Column(name = "dias")
    private String dias;

    @Column(name = "hora_inicio")
    private String horaInicio;

    @Column(name = "hora_fin")
    private String horaFin;

}
