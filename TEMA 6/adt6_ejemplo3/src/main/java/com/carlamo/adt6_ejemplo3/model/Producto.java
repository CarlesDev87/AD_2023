package com.carlamo.adt6_ejemplo3.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = true, length = 150)
    @Size(min = 3, max = 150, message = "Descripción debe estar entre 3 y 150 caracteres")
    private String descripcion;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(nullable = false)
    private float precio;

    @Column(name="fecha_creacion")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaCreacion;



}
