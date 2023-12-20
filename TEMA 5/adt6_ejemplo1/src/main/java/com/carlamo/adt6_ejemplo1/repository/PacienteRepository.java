package com.carlamo.adt6_ejemplo1.repository;

import com.carlamo.adt6_ejemplo1.model.Paciente;
import org.springframework.stereotype.Repository;

@Repository
public class PacienteRepository {

    public String saludar(Paciente p) {
        return p.getNombre();
    }


}
