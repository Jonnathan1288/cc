package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "evalucionformativacurriculares")
public class EvalucionFormativaCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evalucion_formativa_curricular")
    private Integer idEvalucionFormativaCurricular;

    @Column(name = "tecnica_formativa", length = 1000)
    private String tecnicaFormativa;

    @Column(name = "instrumneto_formativa", length = 1000)
    private String instrumnetoFormativa;

    @Column(name = "estadoEvaluacionFormativa", columnDefinition = "BOOLEAN")
    private Boolean estadoEvaluacionFormativa;


    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="id_disenio_curricular",referencedColumnName ="id_disenio_curricular")
    private DisenioCurricular disenioCurricular;
}
