package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "diseniocurriculares")
public class DisenioCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disenio_curricular")
    private Integer idDisenioCurricular;

    @Column(name = "temas_transversales", length = 1500)
    private String temasTransversales;

    @Column(name = "estrategias_aprendizaje", length = 1500)
    private String estrategiasAprendizaje;

    @Column(name = "estado_disenio_curricular", columnDefinition = "BOOLEAN")
    private Boolean estadoDisenioCurricular;

    // RELACIONAR CON EL SILABO
    @ManyToOne
    @JoinColumn(name="id_silabo",referencedColumnName ="id_silabo")
    private Silabo silabo;

    //Falta refe -> EntornoAprendizajeCurricular, MecanismosEvaluacionCurricular
}
