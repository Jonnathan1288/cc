package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "silabos")
public class Silabo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_silabo")
    private Integer idSilabo;

    @Column(name = "bibliografia", length = 1800)
    private String bibliografia;

    @Column(name = "campo_formacion", length = 1000)
    private String campoFormacion;

    @Column(name = "campo_revisado_por", length = 1000)
    private String campoRevisadoPor;

    @Column(name = "campo_aprovado_por", length = 1000)
    private String campoAprovadoPor;

    // Se relaciona con curso

    @ManyToOne
    @JoinColumn(name="id_curso",referencedColumnName ="id_curso")
    private Curso curso;

    //Falara referencir  con resultado aperesi, contenidosilabos, DisenioCurricular
    @JsonIgnore
    @OneToMany(mappedBy = "silabo")
    private List<ContenidoSilabo> contenidoSilaboList;
}
