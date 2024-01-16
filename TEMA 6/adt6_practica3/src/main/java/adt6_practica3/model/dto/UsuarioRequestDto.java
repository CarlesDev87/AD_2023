package adt6_practica3.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioRequestDto implements Serializable {


    @NotNull
    private String nombre;
    @Size(min = 6, max = 50, message = "Los apellidos deben tener entre 6 y 50 caracteres")
    private String apellidos;
    @Email
    private String email;
    @Pattern(regexp = "^[a-zA-Z0-9]{4,8}")
    private String password;

}
