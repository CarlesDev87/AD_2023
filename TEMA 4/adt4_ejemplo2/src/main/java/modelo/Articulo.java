package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Articulo {
    private String id;
    private String nombre;
    private Float precio;
    private int stock;
    private String imagen;
    private String descripcion;

}
