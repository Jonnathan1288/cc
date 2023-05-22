package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "documentossenecyt")
public class DocumentoSenecyt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento_senecyt")
    private Integer idDocumentoSenecyt;

    @Column(name = "descripcion", length = 1500)
    private String descripcion;

    @Column(name = "documento_exel",  columnDefinition = "LONGBLOB")
    private String documentoExel;

    @Column(name = "estado_documento ", columnDefinition = "BOOLEAN")
    private Boolean estadoDocumento;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;


    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName ="id_usuario")
    private Usuario usuario;

}
