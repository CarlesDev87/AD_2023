package com.carlamo.adt6_practica1.controller;

import com.carlamo.adt6_practica1.model.Vuelo;
import com.carlamo.adt6_practica1.service.VueloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloServiceImpl service;

    @GetMapping
    public List<Vuelo> buscar() {
        return service.buscar();
    }

    @PostMapping
    public Vuelo registrar(Vuelo v) {
         return service.registrar(v);
    }

    @GetMapping
    public Vuelo modificar(Vuelo v) {
        return service.modificar(v);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
    }

}
