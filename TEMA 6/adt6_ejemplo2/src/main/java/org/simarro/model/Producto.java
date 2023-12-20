package org.simarro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

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
    private String descripcion;

    @Column(nullable = false, length = 50)
    private String categoria;

    @Column(nullable = false)
    private float precio;

    @Column(name="fecha_creacion")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate fechaCreacion;



}
