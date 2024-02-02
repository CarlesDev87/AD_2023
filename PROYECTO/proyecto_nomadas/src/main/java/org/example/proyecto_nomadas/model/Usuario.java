package org.example.proyecto_nomadas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String email;

    //Apellidos para los usuarios ?
    //private String apellidos;
    private String contrasena;

    //Telefono ?
    //private Long telefono;

    //Fecha creacion del usuario?
    //@Column(name = "fecha_creacion")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    //private LocalDate fechaCreacion;


}
