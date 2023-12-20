package com.carlamo.adt6_practica1.service;

import com.carlamo.adt6_practica1.model.Vuelo;
import com.carlamo.adt6_practica1.repository.IVueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServiceImpl implements IVueloService{

    @Autowired
    private IVueloRepository repo;
    @Override
    public List<Vuelo> buscar() {
        return repo.findAll();
    }

    @Override
    public Vuelo registrar(Vuelo v) {
        return repo.save(v);
    }

    @Override
    public Vuelo modificar(Vuelo v) {
        return repo.save(v);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
