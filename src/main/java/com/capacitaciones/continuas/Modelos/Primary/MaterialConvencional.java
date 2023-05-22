package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "material_convencionales")
public class MaterialConvencional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material_monvencional")
    private Integer idMaterialConvencional;

    @Column(name = "descripcion_material_convencional", length = 1500)
    private String descripcionMaterialConvencional;

    @Column(name = "estado_material_convencional", columnDefinition = "BOOLEAN")
    private Boolean estadoMaterialConvencional;

    @ManyToOne
    @JoinColumn(name="id_silabo",referencedColumnName ="id_silabo")
    private Silabo silabo;


}
