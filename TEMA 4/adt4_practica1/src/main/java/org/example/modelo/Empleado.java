package org.example.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Empleado {
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private double salario;


}
