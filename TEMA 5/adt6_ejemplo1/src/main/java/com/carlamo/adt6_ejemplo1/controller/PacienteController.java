package com.carlamo.adt6_ejemplo1.controller;

import com.carlamo.adt6_ejemplo1.model.Paciente;
import com.carlamo.adt6_ejemplo1.repository.PacienteRepository;
import com.carlamo.adt6_ejemplo1.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping
    public String saludar(Paciente paciente) {
        Paciente p = new Paciente();
        p.setId(1);
        p.setNombre("Pepe");
        //service = new PacienteService();
        return  service.saludar(p);
    }
}
