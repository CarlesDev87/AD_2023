package com.carlamo.adt6_ejemplo1.service;

import com.carlamo.adt6_ejemplo1.model.Paciente;
import com.carlamo.adt6_ejemplo1.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repo;

    public String saludar(Paciente p) {

       // repo = new PacienteRepository();
        return repo.saludar(p);

    }

}
