package com.capacitaciones.continuas.Modelos.Secondary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "docentesfenix")
public class DocenteFenix {
    @Id
    @Column(name = "identificacion", nullable = false,updatable = false)
    private String identificacion;

    @Column(name = "nombre1")
    private String nombre1;

    @Column(name = "nombre2")
    private String nombre2;

    @Column(name = "apellido1")
    private String apellido1;

    @Column(name = "apellido2")
    private String apellido2;

    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "celular")
    private String celular;

    @Column(name = "genero")
    private String genero;

    @Column(name = "etnia")
    private String etnia;

    @Column(name = "tituloCapacitador")
    private String tituloCapacitador;

    @Column(name = "tipoAbreviaturaTitulo")
    private String tipoAbreviaturaTitulo;
}
