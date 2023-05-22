package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "periodos_programas")
public class PeriodoPrograma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodo_programa")
    private Integer idPeriodoPrograma;

    @Column(name = "estado_periodo_programa", columnDefinition = "BOOLEAN")
    private Boolean estadoPeriodoPrograma;

    @Column(name = "fecha_inicio_periodo_programa")
    private LocalDate fechaInicioPeriodoPrograma;

    @Column(name = "fecha_fin_periodo_programa")
    private LocalDate fechaFinPeriodoPrograma;

    @Column(name = "nombre_periodo_programa", length = 500)
    private String nombrePeriodoPrograma;

    @JsonIgnore
    @OneToOne(mappedBy = "periodoPrograma")
    private Programas programas;
    
}
