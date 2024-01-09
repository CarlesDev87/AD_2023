package com.carlamo.adt6_practica1.service;

import com.carlamo.adt6_practica1.model.Vuelo;

import java.util.List;

public interface IVueloService {
    List<Vuelo> buscar();
    Vuelo registrar(Vuelo v);
    Vuelo modificar(Vuelo v);
    void eliminar(Integer id);

    List<Vuelo> borrarPorDestino(String destino);

}
