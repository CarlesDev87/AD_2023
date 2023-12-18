package com.carlamo.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="empleados")

public class Empleado {

    @Id
    @Column(name="DNI")
    private String dni;

    @Column(name="Nombre")
    private String nombre;

    @Column(name="Apellidos")
    private String apellidos;

    @Column(name="Edad")
    private int edad;

    @Column(name="Salario")
    private Float salario;


}
