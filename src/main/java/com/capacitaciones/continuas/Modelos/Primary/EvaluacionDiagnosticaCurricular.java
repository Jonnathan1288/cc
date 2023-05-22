package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "evaluaciondiagnosticacurriculares")
public class EvaluacionDiagnosticaCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evaluacion_diagnostica_curricular")
    private Integer idEvaluacionDiagnosticaCurricular;

    @Column(name = "tecnica_evaluar", length = 1000)
    private String tecnicaEvaluar;

    @Column(name = "instrumneto_evaluar", length = 1000)
    private String instrumnetoEvaluar;

    //NUEVO ATRIBUTO
    @Column(name = "estadoEvaluacionDiagnostica", columnDefinition = "BOOLEAN")
    private Boolean estadoEvaluacionDiagnostica;

    // se relaciona con mecanismo
    @ManyToOne
    @JoinColumn(name="id_disenio_curricular",referencedColumnName ="id_disenio_curricular")
    private DisenioCurricular disenioCurricular;
}
